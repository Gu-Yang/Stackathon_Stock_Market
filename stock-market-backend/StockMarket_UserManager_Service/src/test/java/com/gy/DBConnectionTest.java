package com.gy;

import com.gy.entity.User;
import com.gy.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBConnectionTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateTable() {

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("Zhandan");
        user.setPassword("12345678");
        user.setEmail("4324678@123.com");
        user.setMobile("74324743");

        userRepository.save(user);
    }

}
