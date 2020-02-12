package cn.web1992.mybatiss;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 这里关闭事务，如果这里开启事务，事务AOP 总是优选 UserService 上的事务，导致数据源切换失败
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(false)
//@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = {"classpath*:/config/spring/spring-application.xml"})
public class AbstractTest {
}
