package cn.web1992.mybatiss.dal.dao;

import cn.web1992.mybatiss.dal.domain.Person;

/**
 * @author web1992
 */
public interface PersonDao {


    Integer update(Person person);


    Person get(String personId);
}
