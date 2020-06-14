package com.gy;

import com.gy.controller.LoginController;
import com.gy.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    public void testFindUser() {
        User user = loginController.getUserByUsername("llicd");
        System.out.println(user);
    }
}