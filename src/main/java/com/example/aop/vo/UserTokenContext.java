package com.example.aop.vo;

import org.springframework.beans.factory.BeanFactory;

/**
 * 用户登录token
 *
 * @author chang qi
 * @date 2024/11/16
 */
public class UserTokenContext {

    private static final ThreadLocal<String> userToken = ThreadLocal.withInitial(() -> null);

    public static String getToken() {
        return userToken.get();
    }

    public static void setToken(String token) {
//        BeanFactory
        userToken.set(token);
    }

    public static void remove() {
        userToken.remove();
    }
}
