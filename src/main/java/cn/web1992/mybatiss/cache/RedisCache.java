package cn.web1992.mybatiss.cache;

import cn.web1992.mybatiss.utils.SHA1Utils;
import org.apache.ibatis.cache.Cache;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author web1992
 * @date 2020/2/16  11:38
 * @desc 使用 HashMap 模拟 Redis 缓存
 * <pre>
 *     1. 使用 sha1 压缩 key
 *     2. hash 算法会产生冲突，需要解决hash 冲突,引入 nameSpace 减少冲突的发生
 *     3. 在存储List 到缓存中，包装成CacheValue 对象， 把实际类型的也进行存储，在从缓存取出来之后，进行对比，解决hash 冲突
 *     4. 考虑最大支持的缓存数量(条数，字节大小等考虑)的膨胀
 *     5. 考虑缓存的淘汰策略，当缓存数量到达多少的时候，进行缓存key 的淘汰，避免内存浪费和溢出
 *     6. 考虑读数据进行压缩(如序列化)，节约内存
 *     7. 使用 redis 中的 set NX 命令避免覆盖已经存在的 key
 *     8. 需要解决缓存删除失败，等缓存一致性问题
 *     9. 添加数据缓存版本控制，方便缓存升级
 * </pre>
 *
 * <pre>
 *     基于 mybatis Cache 实现的缓存的优点和缺点：
 *     1. 一种 mapper(SQL)  对象对应一个缓存对象(mapper-> MappedStatement -> SQL 语句)
 *     2. mybatis 已经实现了缓存key 的包装，不需要自己额外的包装组装key
 *     3. 更新和删除操作会自动删除 mapper 对应的所有缓存
 *     4. 删除缓存的力度不够细
 *     5. 配置不够方便
 *     6. 在mapper 中启用了缓存，那么默认这个Mapper里面的查询都会被缓存，需要注意
 *        如果不想使用，需要手动禁用缓存
 * </pre>
 */
public class RedisCache implements Cache {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    private Cache delegate;

    /**
     * 缓存key 的命令空间
     */
    private String nameSpace;

    /**
     * 过期时间
     * 单位秒
     * 尽量使用不同的过期时间，避免key集体失效
     */
    private int expire;

    Map<Object, Object> map = new HashMap<>();

    public RedisCache(String id) {
        this.id = id;
    }

    public RedisCache(Cache delegate) {
        this.delegate = delegate;
    }

    public Cache getDelegate() {
        return delegate;
    }

    public void setDelegate(Cache delegate) {
        this.delegate = delegate;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getSize() {
        return 1024;
    }

    @Override
    public void putObject(Object key, Object value) {
        map.put(getKey(key), value);
    }

    @Override
    public Object getObject(Object key) {


        return map.get(getKey(key));
    }

    @Override
    public Object removeObject(Object key) {
        return map.remove(getKey(key));
    }

    @Override
    public void clear() {
        System.out.println("clear ...");
        map.clear();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }


    private String getKey(Object key) {
        String hashKey = SHA1Utils.hash(key.toString()) + "-" + nameSpace;
        return hashKey;
    }

    static class CacheValue {

        /**
         * 记录实际的类型
         */
        private Class<?> clazz;

        private Date creTime;

        private List<?> list;


        public static Class<?> getClazz(List<?> list) {
            if (null == list || list.isEmpty()) {
                return null;
            }
            Object o = list.get(0);

            return o.getClass();
        }

        public CacheValue(List<?> list) {
            this(getClazz(list), new Date(), list);
        }

        public CacheValue(Class<?> clazz, Date creTime, List<?> list) {
            this.clazz = clazz;
            this.creTime = creTime;
            this.list = list;
        }


        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }

        public Date getCreTime() {
            return creTime;
        }

        public void setCreTime(Date creTime) {
            this.creTime = creTime;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }
    }
}
