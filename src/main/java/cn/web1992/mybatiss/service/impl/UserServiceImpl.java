package cn.web1992.mybatiss.service.impl;

import cn.web1992.mybatiss.dal.dao.UserDao;
import cn.web1992.mybatiss.dal.domain.User;
import cn.web1992.mybatiss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int createUser(User user) {
        return userDao.add(user);
    }

    @Override
    public User queryUser(Long id) {
        return userDao.get(id);
    }
}
