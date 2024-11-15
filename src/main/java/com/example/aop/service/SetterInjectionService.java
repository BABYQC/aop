package com.example.aop.service;

import com.example.aop.entity.CloudFile;
import com.example.aop.mapper.CloudFileMapper;
import org.springframework.stereotype.Service;

/**
 * setter函数注入
 *
 * @Author: chang qi
 * @Date: 2024/11/15
 */
@Service
public class SetterInjectionService {

    private CloudFileMapper cloudFileMapper;

    public void setCloudFileMapper(CloudFileMapper cloudFileMapper) {
        this.cloudFileMapper = cloudFileMapper;
    }

    public CloudFile getCloudFileById(String id) {
        return cloudFileMapper.selectCloudFileById(id);
    }
}
