package cn.web1992.mybatiss.dal.dao;

import cn.web1992.mybatiss.dal.domain.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author web1992
 */
public interface UserDao {

    User get(String id);

    Integer update(User user);

    int add(User user);

    List<User> queryAll();

    /**
     * 使用 RowBounds 实现分页查询
     *
     * @param rowBounds
     * @return
     */
    List<User> queryAllB(RowBounds rowBounds);

    User getByName(String name);
}
