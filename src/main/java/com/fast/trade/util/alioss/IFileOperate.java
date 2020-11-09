package com.fast.trade.util.alioss;

import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ProcessObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/10/27 14:28
 * @decription: 文件上传接口
 */
public interface IFileOperate {
    /**
     * 使用文件file统一上传
     * @param fileMap
     * @return
     */
    List<String> upload(Map<String, File> fileMap);

    /**
     * 使用流上传
     * @param fileMap
     * @return
     */
    List<String> uploadInputStream(Map<String, InputStream> fileMap);


    /**
     * 删除单个对象
     * @param backetName
     * @param backUrl
     * @return
     */
    boolean deleteObject(String backetName, String backUrl);

    /**
     * 获取临时url
     * @param backetName
     * @param backUrl
     * @return
     */
    String getUrl(String backetName, String backUrl, Date expired);

    /**
     * 获取对象
     * @param backetName
     * @param backUrl
     */
    InputStream getObject(String backetName, String backUrl);

    /**
     * 获取对象
     * @param getObjectRequest
     * @param file
     * @return
     */
    boolean getObject(GetObjectRequest getObjectRequest, File file);

    /**
     * 批量删除
     * @param keys
     * @return
     */
    int deleteObjects(List<String> keys, String backetName);


    /**
     * 列出文件夹下所有文件
     * @param backetName
     * @return
     */
    List<String> listObjects(String backetName, String directory);

    /**
     *
     * @param putObjectRequest
     * @return
     */
    boolean putObject(PutObjectRequest putObjectRequest);


    /**
     * 图片处理
     * @param processObjectRequest
     * @return
     */
    String imgaeHandler(ProcessObjectRequest processObjectRequest);
}
