package cn.web1992.mybatiss.service.impl;

import cn.web1992.mybatiss.dal.dao.UserDao;
import cn.web1992.mybatiss.dal.domain.User;
import cn.web1992.mybatiss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author web1992
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 使用 Spring 事务
     *
     * @param user
     * @return
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public int createUser(User user) {
        return userDao.add(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public User queryUser(String id) {
        return userDao.get(id);
    }
}
