package cn.web1992.mybatiss.service.impl;

import cn.web1992.mybatiss.dal.dao.UserDao;
import cn.web1992.mybatiss.dal.domain.User;
import cn.web1992.mybatiss.datasource.UseDataSource;
import cn.web1992.mybatiss.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    /**
     * 默认数据源是 dataSourceMySQL
     * id='u1' 时，User 不为空，说明数据源切换OK
     *
     * @param id
     * @return
     */
    @Override
    @UseDataSource("embeddedDatabase")
//    @UseDataSource("dataSourceMySQL")
    @Transactional(rollbackFor = Exception.class)
    public User queryUser(String id) {
        return userDao.get(id);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllB(new RowBounds(0, 3));
//        PageHelper.startPage(1, 3);
//        return userDao.queryAll();
    }
}
