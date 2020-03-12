package cn.web1992.mybatiss.service.impl;

import cn.web1992.mybatiss.dal.dao.UserDao;
import cn.web1992.mybatiss.dal.domain.Person;
import cn.web1992.mybatiss.dal.domain.User;
import cn.web1992.mybatiss.datasource.UseDataSource;
import cn.web1992.mybatiss.service.PersonService;
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

    @Autowired
    private PersonService personService;

    /**
     * 使用 Spring 事务
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @UseDataSource("embeddedDatabase")
    public int createUser(User user) {
        return userDao.add(user);
    }

    @Override
    @UseDataSource("embeddedDatabase")
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {

        Person person = new Person();
        person.setPersonId(1);
        person.setFirstName("ads");
        try {
            personService.updateUser(person);
            System.out.println(personService.queryUser("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (true) {
            userDao.update(user);
            throw new RuntimeException("UUUUU");
        }

        return 0;
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
    public User queryUserByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllB(new RowBounds(0, 3));
//        return userDao.queryAll();
    }
}
