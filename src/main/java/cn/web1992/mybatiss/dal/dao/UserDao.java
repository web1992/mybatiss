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

    List<User> queryAllB(RowBounds rowBounds);

}
