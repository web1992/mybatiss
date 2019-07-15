package cn.web1992.mybatiss.service.impl;

import cn.web1992.mybatiss.service.User;
import cn.web1992.mybatiss.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public int createUser(User user) {
        return 0;
    }

    @Override
    public User queryUser(Long id) {
        return null;
    }
}
