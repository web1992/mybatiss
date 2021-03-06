package cn.web1992.mybatiss.dal.domain;

import java.io.Serializable;

/**
 * @author web1992
 * 二级缓存，User 对象需要实现序列化接口
 */
public class User implements Serializable {

    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
