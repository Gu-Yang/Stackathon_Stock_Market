package com.gy;

import com.gy.controller.UserController;
import com.gy.entity.User;
import com.gy.entity.request.UserNameRequest;
import com.gy.entity.request.UserRequest;
import com.gy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Test
    public void testFindUser() {
        UserNameRequest request = new UserNameRequest();
        request.setUsername("llicd");
        User user = userController.findUser(request);
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        UserRequest user1 = new UserRequest("gyangcd", "123456", "GuYang", "44213213@qq.com", "2134324543");
        UserRequest user2 = new UserRequest("zdancd", "123456", "ZhanDan", "32157564@qq.com", "13984754387");
        UserRequest user3 = new UserRequest("llicd", "123456", "LiLi", "84324554@qq.com", "15635544674");
        UserRequest user4 = new UserRequest("xguocd", "123456", "Xiangguo", "5643566@qq.com", "146455476");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        userController.addUser(user4);
    }

    @Test
    public void deleteAllUsers() {
        userController.deleteAllUsers();
    }

    @Test
    public void addAdmin() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setName("GuYang");
        admin.setEmail("3123123@qq.com");
        admin.setMobile("1864235435");
        admin.setRole("admin");
        userService.addUser(admin);
    }
}