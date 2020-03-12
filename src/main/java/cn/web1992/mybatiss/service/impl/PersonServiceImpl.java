package cn.web1992.mybatiss.service.impl;

import cn.web1992.mybatiss.dal.dao.PersonDao;
import cn.web1992.mybatiss.dal.domain.Person;
import cn.web1992.mybatiss.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonDao personDao;

    @Override
//    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRES_NEW)
    public int updateUser(Person person) {
        if (true) {
            personDao.update(person);
//            throw new RuntimeException("ewrewre");
        }

        return 0;
    }

    @Override
    public Person queryUser(String id) {
        return personDao.get(id);
    }
}
