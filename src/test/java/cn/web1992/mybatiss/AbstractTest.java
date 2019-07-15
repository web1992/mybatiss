package cn.web1992.mybatiss;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(false)
@Transactional(transactionManager = "transactionManager")
@ContextConfiguration(locations = {"classpath*:/config/spring/spring-application.xml"})
public class AbstractTest {
}
