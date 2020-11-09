package com.fast.trade.util.alioss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/10/27 14:36
 * @decription:
 */

public class AliFileOperate implements IFileOperate {
    private static final Logger logger = LoggerFactory.getLogger(AliFileOperate.class);
    @Override
    public List<String> upload(Map<String, File> fileMap) {
        List<String> resultList = new ArrayList<>();
        if (CollectionUtils.isEmpty(fileMap)){
            return resultList;
        }
        OSS ossClient = getOssClient();
        try {
            for (String fileName : fileMap.keySet()){
                File file = fileMap.get(fileName);
                ossClient.putObject(AliUploaderAuth.getBucketName(), fileName, file);
                resultList.add(AliUploaderAuth.getBucketUrl()+"/"+fileName);
            }
            return resultList;
        }catch (Exception e){
            logger.error("文件上传失败",e);
        }finally {
            ossClient.shutdown();
        }
        return resultList;
    }

    @Override
    public List<String> uploadInputStream(Map<String, InputStream> fileMap) {
        List<String> resultList = new ArrayList<>();
        if (CollectionUtils.isEmpty(fileMap)){
            return resultList;
        }
        OSS ossClient = getOssClient();
        try {
            for (String fileName : fileMap.keySet()){
                InputStream inputStream = fileMap.get(fileName);
                ossClient.putObject(AliUploaderAuth.getBucketName(), fileName, inputStream);
                resultList.add(AliUploaderAuth.getBucketUrl()+"/"+fileName);
            }
        }catch (Exception e){
            logger.error("文件流上传失败",e);
        }finally {
            ossClient.shutdown();
        }
        return resultList;
    }

    @Override
    public boolean deleteObject(String backetName, String backUrl) {

        OSS ossClient = getOssClient();
        try {
            ossClient.deleteObject(backetName,backUrl);
            return true;
        }catch (Exception e){
            logger.error("删除文件失败",e);
            return false;
        }finally {
            ossClient.shutdown();
        }
    }

    @Override
    public String getUrl(String backetName, String backUrl,Date expired) {
        OSS ossClient = getOssClient();
        try {
            URL url = ossClient.generatePresignedUrl(backetName, backUrl, expired);
            if (url != null){
                return url.toString();
            }
        }catch (Exception e){
            logger.error("获取文件url失败",e);
            return null;
        }finally {
            ossClient.shutdown();
        }

        return null;
    }

    @Override
    public InputStream getObject(String backetName, String backUrl) {
        OSS ossClient = getOssClient();
        try {
            OSSObject object = ossClient.getObject(backetName, backUrl);
            if (object != null){
                return object.getObjectContent();
            }
        }catch (Exception e){
            logger.error("查看文件对象失败",e);
            return null;
        }finally {
            ossClient.shutdown();
        }
        return null;
    }

    @Override
    public boolean getObject(GetObjectRequest getObjectRequest, File file) {
        OSS ossClient = getOssClient();
        try {
            ObjectMetadata object = ossClient.getObject(getObjectRequest, file);
            if (object != null){
                return true;
            }
        }catch (Exception e){
            logger.error("查看文件对象失败",e);
            return false;
        }finally {
            ossClient.shutdown();
        }
        return false;
    }

    @Override
    public int deleteObjects(List<String> keys,String backetName) {
        if (keys == null || keys.size() < 1){
            return 0;
        }
        OSS ossClient = getOssClient();
        try {
            DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(backetName);
            deleteObjectsRequest.withKeys(keys);
            return ossClient.deleteObjects(deleteObjectsRequest).getDeletedObjects().size();
        }catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }finally {
            ossClient.shutdown();
        }

    }

    @Override
    public List<String> listObjects(String backetName, String directory) {
        OSS ossClient = getOssClient();
        List<String> keys = new ArrayList<>();
        try {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
            listObjectsRequest.setBucketName(backetName);
            listObjectsRequest.setPrefix(directory);
            listObjectsRequest.setDelimiter("/");
            ObjectListing objectListing = ossClient.listObjects(listObjectsRequest);
            List<OSSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
            if (objectSummaries != null && objectSummaries.size() > 0){
                objectSummaries.stream().forEach(item -> {
                    keys.add(item.getKey());
                });
            }
            return keys;
        }catch (Exception e){
            logger.error("查看文件列表失败",e);
        }finally {
            ossClient.shutdown();
        }
        return keys;
    }

    @Override
    public boolean putObject(PutObjectRequest putObjectRequest) {
        OSS ossClient = getOssClient();
        try {
            ossClient.putObject(putObjectRequest);
            return true;
        }catch (Exception e){
            logger.error("上传文件失败",e);
            return false;
        }finally {
            ossClient.shutdown();
        }
    }

    @Override
    public String imgaeHandler(ProcessObjectRequest processObjectRequest) {
        OSS ossClient = getOssClient();
        try {
            GenericResult genericResult = ossClient.processObject(processObjectRequest);
            return IOUtils.readStreamAsString(genericResult.getResponse().getContent(), "UTF-8");
        } catch (IOException e) {
            logger.error("转json失败",e.getMessage());
        } catch (Exception e){
            logger.error("图片持久化失败",e.getMessage());
        }finally {
            ossClient.shutdown();
        }
        return null;
    }


    private OSS getOssClient() {
        return new OSSClientBuilder().build(AliUploaderAuth.getEndPoint(), AliUploaderAuth.getAccessKeyId(), AliUploaderAuth.getAccessKeySecret());
    }
}
