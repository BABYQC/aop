package com.example.aop.controller;

import com.example.aop.service.IUserService;
import com.example.aop.service.UserServiceImpl;
import com.example.aop.vo.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chang qi
 * @date 2025/2/17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping("/add")
    public void addUser(UserInfo userInfo) {
        userService.addUser(userInfo);
    }
}
