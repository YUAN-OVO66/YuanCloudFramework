package com.yuan.cloudcore.file.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文件记录表
 * @TableName file_detail
 */
@TableName(value ="file_detail")
@Data
public class FileDetail implements Serializable {
    public static final String COL_URL = "url";
    public static final String COL_ID = "id";
    /**
     * 文件id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 文件访问地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 文件大小，单位字节
     */
    @TableField(value = "size")
    private Long size;

    /**
     * 文件名称
     */
    @TableField(value = "filename")
    private String filename;

    /**
     * 原始文件名
     */
    @TableField(value = "original_filename")
    private String originalFilename;

    /**
     * 基础存储路径
     */
    @TableField(value = "base_path")
    private String basePath;

    /**
     * 存储路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 文件扩展名
     */
    @TableField(value = "ext")
    private String ext;

    /**
     * MIME类型
     */
    @TableField(value = "content_type")
    private String contentType;

    /**
     * 存储平台
     */
    @TableField(value = "platform")
    private String platform;

    /**
     * 缩略图访问路径
     */
    @TableField(value = "th_url")
    private String thUrl;

    /**
     * 缩略图名称
     */
    @TableField(value = "th_filename")
    private String thFilename;

    /**
     * 缩略图大小，单位字节
     */
    @TableField(value = "th_size")
    private Long thSize;

    /**
     * 缩略图MIME类型
     */
    @TableField(value = "th_content_type")
    private String thContentType;

    /**
     * 文件所属对象id
     */
    @TableField(value = "object_id")
    private String objectId;

    /**
     * 文件所属对象类型，例如用户头像，评价图片
     */
    @TableField(value = "object_type")
    private String objectType;

    /**
     * 文件元数据
     */
    @TableField(value = "metadata")
    private String metadata;

    /**
     * 文件用户元数据
     */
    @TableField(value = "user_metadata")
    private String userMetadata;

    /**
     * 缩略图元数据
     */
    @TableField(value = "th_metadata")
    private String thMetadata;

    /**
     * 缩略图用户元数据
     */
    @TableField(value = "th_user_metadata")
    private String thUserMetadata;

    /**
     * 附加属性
     */
    @TableField(value = "attr")
    private String attr;

    /**
     * 文件ACL
     */
    @TableField(value = "file_acl")
    private String fileAcl;

    /**
     * 缩略图文件ACL
     */
    @TableField(value = "th_file_acl")
    private String thFileAcl;

    /**
     * 哈希信息
     */
    @TableField(value = "hash_info")
    private String hashInfo;

    /**
     * 上传ID，仅在手动分片上传时使用
     */
    @TableField(value = "upload_id")
    private String uploadId;

    /**
     * 上传状态，仅在手动分片上传时使用，1：初始化完成，2：上传完成
     */
    @TableField(value = "upload_status")
    private Integer uploadStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FileDetail other = (FileDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
                && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
                && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
                && (this.getOriginalFilename() == null ? other.getOriginalFilename() == null : this.getOriginalFilename().equals(other.getOriginalFilename()))
                && (this.getBasePath() == null ? other.getBasePath() == null : this.getBasePath().equals(other.getBasePath()))
                && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
                && (this.getExt() == null ? other.getExt() == null : this.getExt().equals(other.getExt()))
                && (this.getContentType() == null ? other.getContentType() == null : this.getContentType().equals(other.getContentType()))
                && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
                && (this.getThUrl() == null ? other.getThUrl() == null : this.getThUrl().equals(other.getThUrl()))
                && (this.getThFilename() == null ? other.getThFilename() == null : this.getThFilename().equals(other.getThFilename()))
                && (this.getThSize() == null ? other.getThSize() == null : this.getThSize().equals(other.getThSize()))
                && (this.getThContentType() == null ? other.getThContentType() == null : this.getThContentType().equals(other.getThContentType()))
                && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
                && (this.getObjectType() == null ? other.getObjectType() == null : this.getObjectType().equals(other.getObjectType()))
                && (this.getMetadata() == null ? other.getMetadata() == null : this.getMetadata().equals(other.getMetadata()))
                && (this.getUserMetadata() == null ? other.getUserMetadata() == null : this.getUserMetadata().equals(other.getUserMetadata()))
                && (this.getThMetadata() == null ? other.getThMetadata() == null : this.getThMetadata().equals(other.getThMetadata()))
                && (this.getThUserMetadata() == null ? other.getThUserMetadata() == null : this.getThUserMetadata().equals(other.getThUserMetadata()))
                && (this.getAttr() == null ? other.getAttr() == null : this.getAttr().equals(other.getAttr()))
                && (this.getFileAcl() == null ? other.getFileAcl() == null : this.getFileAcl().equals(other.getFileAcl()))
                && (this.getThFileAcl() == null ? other.getThFileAcl() == null : this.getThFileAcl().equals(other.getThFileAcl()))
                && (this.getHashInfo() == null ? other.getHashInfo() == null : this.getHashInfo().equals(other.getHashInfo()))
                && (this.getUploadId() == null ? other.getUploadId() == null : this.getUploadId().equals(other.getUploadId()))
                && (this.getUploadStatus() == null ? other.getUploadStatus() == null : this.getUploadStatus().equals(other.getUploadStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getOriginalFilename() == null) ? 0 : getOriginalFilename().hashCode());
        result = prime * result + ((getBasePath() == null) ? 0 : getBasePath().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getExt() == null) ? 0 : getExt().hashCode());
        result = prime * result + ((getContentType() == null) ? 0 : getContentType().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getThUrl() == null) ? 0 : getThUrl().hashCode());
        result = prime * result + ((getThFilename() == null) ? 0 : getThFilename().hashCode());
        result = prime * result + ((getThSize() == null) ? 0 : getThSize().hashCode());
        result = prime * result + ((getThContentType() == null) ? 0 : getThContentType().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getObjectType() == null) ? 0 : getObjectType().hashCode());
        result = prime * result + ((getMetadata() == null) ? 0 : getMetadata().hashCode());
        result = prime * result + ((getUserMetadata() == null) ? 0 : getUserMetadata().hashCode());
        result = prime * result + ((getThMetadata() == null) ? 0 : getThMetadata().hashCode());
        result = prime * result + ((getThUserMetadata() == null) ? 0 : getThUserMetadata().hashCode());
        result = prime * result + ((getAttr() == null) ? 0 : getAttr().hashCode());
        result = prime * result + ((getFileAcl() == null) ? 0 : getFileAcl().hashCode());
        result = prime * result + ((getThFileAcl() == null) ? 0 : getThFileAcl().hashCode());
        result = prime * result + ((getHashInfo() == null) ? 0 : getHashInfo().hashCode());
        result = prime * result + ((getUploadId() == null) ? 0 : getUploadId().hashCode());
        result = prime * result + ((getUploadStatus() == null) ? 0 : getUploadStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", url=").append(url);
        sb.append(", size=").append(size);
        sb.append(", filename=").append(filename);
        sb.append(", originalFilename=").append(originalFilename);
        sb.append(", basePath=").append(basePath);
        sb.append(", path=").append(path);
        sb.append(", ext=").append(ext);
        sb.append(", contentType=").append(contentType);
        sb.append(", platform=").append(platform);
        sb.append(", thUrl=").append(thUrl);
        sb.append(", thFilename=").append(thFilename);
        sb.append(", thSize=").append(thSize);
        sb.append(", thContentType=").append(thContentType);
        sb.append(", objectId=").append(objectId);
        sb.append(", objectType=").append(objectType);
        sb.append(", metadata=").append(metadata);
        sb.append(", userMetadata=").append(userMetadata);
        sb.append(", thMetadata=").append(thMetadata);
        sb.append(", thUserMetadata=").append(thUserMetadata);
        sb.append(", attr=").append(attr);
        sb.append(", fileAcl=").append(fileAcl);
        sb.append(", thFileAcl=").append(thFileAcl);
        sb.append(", hashInfo=").append(hashInfo);
        sb.append(", uploadId=").append(uploadId);
        sb.append(", uploadStatus=").append(uploadStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
