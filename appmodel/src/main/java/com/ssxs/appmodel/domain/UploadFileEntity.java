/**
 *
 */
package com.ssxs.appmodel.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.File;
import java.io.Serializable;

/**
 * 上传文件对象的抽象
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:20
 * modifyTime:
 * modifyBy:
 */
public class UploadFileEntity implements Serializable {
    private static final long serialVersionUID = 6716888611147066411L;
    /**
     * 需要上传的文件名称
     */
    private String uploadFileName;
    /**
     * 上传文件的真实地址，即存放在server的哪里，带有环境的路径
     */
    private String fileRealDir;
    /**
     * 存放的文件原始目录
     */
    private String fileDir;
    /**
     * 将要上传的文件
     */
    private File upFile;
    /**
     * 上传后创建的文件路径
     */
    private String createdImgPath;
    /**
     * 上传创建的缩略图文件路径
     */
    private String createdThumbPath;
    /**
     * 小图片原有地址
     */
    private String oldImgPath;
    /**
     * 缩略图片原有地址:thumb_120_164_oldImagePath
     */
    private String oldThumbPath;

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getFileRealDir() {
        return fileRealDir;
    }

    public void setFileRealDir(String fileRealDir) {
        this.fileRealDir = fileRealDir;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public File getUpFile() {
        return upFile;
    }

    public void setUpFile(File upFile) {
        this.upFile = upFile;
    }

    public String getCreatedImgPath() {
        return createdImgPath;
    }

    public void setCreatedImgPath(String createdImgPath) {
        this.createdImgPath = createdImgPath;
    }

    public String getCreatedThumbPath() {
        return createdThumbPath;
    }

    public void setCreatedThumbPath(String createdThumbPath) {
        this.createdThumbPath = createdThumbPath;
    }

    public String getOldImgPath() {
        return oldImgPath;
    }

    public void setOldImgPath(String oldImgPath) {
        this.oldImgPath = oldImgPath;
    }

    public String getOldThumbPath() {
        return oldThumbPath;
    }

    public void setOldThumbPath(String oldThumbPath) {
        this.oldThumbPath = oldThumbPath;
    }
}
