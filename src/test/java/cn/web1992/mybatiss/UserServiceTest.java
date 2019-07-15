package cn.web1992.mybatiss;

import cn.web1992.mybatiss.dal.domain.User;
import cn.web1992.mybatiss.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends AbstractTest {

    @Autowired
    private UserService userService;

    /**
     * desc:
     */
    @Test
    public void getTest(){
        User user = userService.queryUser(1L);
        System.out.println(user);
    }
}
