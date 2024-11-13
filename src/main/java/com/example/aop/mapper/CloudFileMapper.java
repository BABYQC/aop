package com.example.aop.mapper;

import com.example.aop.entity.CloudFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chang qi
 * @Date: 2024/11/13
 */

@Mapper
@Repository
public interface CloudFileMapper {

    // 插入一条记录
    int insertCloudFile(CloudFile cloudFile);

    // 根据ID查询
    CloudFile selectCloudFileById(String id);

    // 查询所有记录
    List<CloudFile> selectAllCloudFiles();

    // 更新一条记录
    int updateCloudFile(CloudFile cloudFile);

    // 根据ID删除
    int deleteCloudFileById(String id);

}
