package cn.web1992.mybatiss.service;

import cn.web1992.mybatiss.dal.domain.Person;

/**
 * @author wangerbao
 */
public interface PersonService {
    int updateUser(Person person);

    Person queryUser(String name);
}
