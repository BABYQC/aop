package com.example.aop.service;

import com.example.aop.entity.CloudFile;
import com.example.aop.mapper.CloudFileMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chang qi
 * @Date: 2024/11/13
 */
@Service
public class CloudFileService {

    @Resource
    private CloudFileMapper cloudFileMapper;

    public int insertCloudFile(CloudFile cloudFile) {
        return cloudFileMapper.insertCloudFile(cloudFile);
    }

    public CloudFile getCloudFileById(String id) {
        return cloudFileMapper.selectCloudFileById(id);
    }

    public List<CloudFile> getAllCloudFiles() {
        return cloudFileMapper.selectAllCloudFiles();
    }

    public int updateCloudFile(CloudFile cloudFile) {
        return cloudFileMapper.updateCloudFile(cloudFile);
    }

    public int deleteCloudFileById(String id) {
        return cloudFileMapper.deleteCloudFileById(id);
    }


}
