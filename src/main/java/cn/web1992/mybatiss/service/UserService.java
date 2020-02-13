package cn.web1992.mybatiss.service;

import cn.web1992.mybatiss.dal.domain.User;

import java.util.List;

public interface UserService {

    int createUser(User user);

    int updateUser(User user);

    User queryUser(String id);

    List<User> queryAllUser();

}
