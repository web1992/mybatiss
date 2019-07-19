package cn.web1992.mybatiss.dal.dao;

import cn.web1992.mybatiss.dal.domain.User;

public interface UserDao {

    User get(String id);

    Integer update(User user);

    int add(User user);
}
