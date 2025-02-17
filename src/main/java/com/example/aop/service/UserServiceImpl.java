package com.example.aop.service;

import com.example.aop.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chang qi
 * @date 2025/2/17
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService{
    @Override
    public void addUser(UserInfo userInfo) {
        log.info("do add user...");
    }
}
