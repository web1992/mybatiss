package cn.web1992.mybatiss.service;

import cn.web1992.mybatiss.dal.domain.User;

public interface UserService {

    int createUser(User user);

    User queryUser(Long id);

}
