package cn.web1992.mybatiss.service;

public interface UserService {

    int createUser(User user);

    User queryUser(Long id);

}
