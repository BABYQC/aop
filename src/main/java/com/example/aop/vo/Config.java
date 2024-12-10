package com.example.aop.vo;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: chang qi
 * @Date: 2024/12/10
 */
@Data
public class Config implements InitializingBean {
    private String name;

    private String host;

    public Config() {
        System.out.println("construct method done!");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean -> afterPropertiesSet() done!");
    }

    @PostConstruct
    public void initUseAnno() {
        System.out.println("PostConstruct done !");
    }
}
