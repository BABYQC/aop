package com.example.aop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 云文件类
 *
 * @Author: chang qi
 * @Date: 2024/11/13
 */
@Data
@Schema(description = "公共文件实体")
public class CloudFile {

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "文件名称")
    private String fileName;

    @Schema(description = "附件类型")
    private String fileType;

    @Schema(description = "业务类型")
    private Integer operationType;

    @Schema(description = "操作人")
    private String operator;

    @Schema(description = "上传时间")
    private Date uploadTime;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "关联业务ID")
    private String relevancyId;

    @Schema(description = "objectKey")
    private String objectKey;

    @Schema(description = "有效期")
    private Date validTime;

    @Schema(description = "文件类型 0：文件夹，1：文件；")
    private Integer fileCategory;
}
