package com.yuan.cloudcore.file.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件分片信息表，仅在手动分片上传时使用
 * @TableName file_part_detail
 */
@TableName(value ="file_part_detail")
@Data
public class FilePartDetail implements Serializable {
    public static final String COL_UPLOAD_ID = "upload_id";
    /**
     * 分片id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 存储平台
     */
    @TableField(value = "platform")
    private String platform;

    /**
     * 上传ID，仅在手动分片上传时使用
     */
    @TableField(value = "upload_id")
    private String uploadId;

    /**
     * 分片 ETag
     */
    @TableField(value = "e_tag")
    private String eTag;

    /**
     * 分片号。每一个上传的分片都有一个分片号，一般情况下取值范围是1~10000
     */
    @TableField(value = "part_number")
    private Integer partNumber;

    /**
     * 文件大小，单位字节
     */
    @TableField(value = "part_size")
    private Long partSize;

    /**
     * 哈希信息
     */
    @TableField(value = "hash_info")
    private String hashInfo;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
