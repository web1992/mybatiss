package cn.web1992.mybatiss;

import cn.web1992.mybatiss.dal.domain.User;
import cn.web1992.mybatiss.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends AbstractTest {

    @Autowired
    private UserService userService;

    /**
     * desc:
     */
    @Test
    public void getTest() {
        User user = userService.queryUser("u1");
        System.out.println(user);

        user = userService.queryUser("u6x");
        System.out.println(user);
    }

    /**
     * 测试
     */
    @Test
    public void createTest() {
        User user1 = new User();
        user1.setName("6666 name");
        user1.setId("u6x");
        userService.createUser(user1);

    }

    /**
     * 测试
     */
    @Test
    public void updateTest() {
        User user = new User();
        user.setName("6666 name");
        user.setId("u6x");
        user.setName("test2");
        userService.updateUser(user);
    }

    /**
     * 测试
     */
    @Test
    public void queryAllTest(){
        List<User> users = userService.queryAllUser();

        System.out.println(users);
    }
}
