package com.example.aop.service;

import com.example.aop.entity.CloudFile;
import com.example.aop.mapper.CloudFileMapper;
import org.springframework.stereotype.Service;

/**
 * 构造函数注入示例
 *
 * @Author: chang qi
 * @Date: 2024/11/15
 */
@Service
public class ConstructorInjectionService {

    private CloudFileMapper cloudFileMapper;

    public ConstructorInjectionService(CloudFileMapper cloudFileMapper) {
        this.cloudFileMapper = cloudFileMapper;
    }

    public CloudFile getCloudFileById(String id) {
        return cloudFileMapper.selectCloudFileById(id);
    }

}
