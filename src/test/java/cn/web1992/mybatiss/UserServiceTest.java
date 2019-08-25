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
        User user = userService.queryUser("u1");
        System.out.println(user);

        User user1 = new User();
        user1.setName("6666 name");
        user1.setId("u6x");
        userService.createUser(user1);

        // user.setName("test2");
        // userService.updateUser(user);

        user = userService.queryUser("u6x");
        System.out.println(user);
    }
}
