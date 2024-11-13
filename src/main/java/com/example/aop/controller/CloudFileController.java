package com.example.aop.controller;

import com.example.aop.entity.CloudFile;
import com.example.aop.service.CloudFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: chang qi
 * @Date: 2024/11/13
 */
@RestController
@RequestMapping("/cloudFile")
public class CloudFileController {

    @Resource
    private CloudFileService cloudFileService;

    @Operation(description = "根据ID获取文件")
    @GetMapping("/{id}")
    public CloudFile getById(@PathVariable String id) {
        return cloudFileService.getCloudFileById(id);
    }

    @Operation(description = "获取所有文件")
    @GetMapping("/list")
    public List<CloudFile> list() {
        return cloudFileService.getAllCloudFiles();
    }

    @Operation(description = "添加新文件")
    @PostMapping
    public int save(@RequestBody CloudFile cloudFile) {
        return cloudFileService.insertCloudFile(cloudFile);
    }

    @Operation(description = "更新文件信息")
    @PutMapping
    public int update(@RequestBody CloudFile cloudFile) {
        return cloudFileService.updateCloudFile(cloudFile);
    }

    @Operation(description = "根据ID删除文件")
    @DeleteMapping("/{id}")
    public int delete(@PathVariable String id) {
        return cloudFileService.deleteCloudFileById(id);
    }
}
