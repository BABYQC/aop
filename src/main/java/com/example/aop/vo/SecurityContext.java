package com.example.aop.vo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author chang qi
 * @date 2024/11/16
 */
public class SecurityContext {
    private static final ThreadLocal<UserInfo> loginUser = ThreadLocal.withInitial(() -> null);

    public static UserInfo get() {
        return loginUser.get();
    }

    public static void setLoginUser(UserInfo userInfo) {
//        BeanDefinitionReader
        loginUser.set(userInfo);
    }

    public static void remove() {
        loginUser.remove();
    }
}
