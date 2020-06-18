package com.gy.service;

import com.gy.entity.User;
import com.gy.entity.request.UserNameRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("user-manager")
public interface RemoteUserService {

    @PostMapping("findUser")
    User findUser(UserNameRequest userNameRequest);

}
