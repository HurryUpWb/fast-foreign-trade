package com.fast.trade.util.alioss;

import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.common.utils.StringUtils;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.ProcessObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.fast.trade.util.alioss.enums.OssFileAclEnums;

import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/10/27 16:14
 * @decription:
 */
public class AliOssUtil {


    private static final String defaultBootPath = "upload";



    /**
     * 上传文件
     *
     * @param file     具体文件
     * @param fileName 文件名 如： xxxx.jpg 如果当前目录文件已存在 则会覆盖
     * @param filePath 文件保存路径 如：upload 如果当前没有则会自动创建
     * @return
     */
    public static String uploadFile(String fileName, String filePath, File file) {

        fileName = getFilePath(fileName, filePath);
        return _upload(file, fileName);
    }



    /**
     * 上传文件
     *
     * @param uploadMap fileName -> file
     * @return
     */
    public static List<String> uploadFiles(Map<String, File> uploadMap) {

        return _upload(uploadMap);
    }



    /**
     * 上传文件
     *
     * @param uploadMap fileName -> file InputStream
     * @return
     */
    public static List<String> uploadFileInputStream(Map<String, InputStream> uploadMap) {

        return _uploadForInputStream(uploadMap);
    }



    /**
     * @param fileName
     * @param inputStream
     * @return
     */
    public static String uploadFile(String fileName, String filePath, InputStream inputStream) {

        fileName = getFilePath(fileName, filePath);
        return _upload(inputStream, fileName);
    }



    private static String getFilePath(String fileName, String filePath) {

        if (StringUtils.isNullOrEmpty(filePath)) {
            filePath = defaultBootPath;
        }
        fileName = filePath + "/" + fileName;
        return fileName;
    }



    /**
     * 默认上传文件路径 upload
     *
     * @param fileName
     * @param file
     * @return
     */
    public static String uploadFile(String fileName, File file) {

        return uploadFile(fileName, null, file);
    }



    /**
     * 默认上传文件路径 upload
     *
     * @param fileName
     * @param inputStream
     * @return
     */
    public static String uploadFile(String fileName, InputStream inputStream) {

        return uploadFile(fileName, null, inputStream);
    }



    /**
     * 根据file上传文件
     *
     * @param fileMap
     * @return
     */
    private static List<String> _upload(Map<String, File> fileMap) {

        _check(fileMap);
        return getOperate().upload(fileMap);
    }



    /**
     * 根据inputstream上传文件
     *
     * @param fileMap
     * @return
     */
    private static List<String> _uploadForInputStream(Map<String, InputStream> fileMap) {

        return getOperate().uploadInputStream(fileMap);
    }



    private static String _upload(InputStream inputStream, String fileName) {

        if (inputStream == null) {
            throw new RuntimeException("无文件上传");
        }
        Map<String, InputStream> fileMap = new HashMap<String, InputStream>();
        fileMap.put(fileName, inputStream);

        return _uploadForInputStream(fileMap).get(0);
    }



    private static String _upload(File file, String fileName) {

        if (file == null) {
            throw new RuntimeException("无文件上传");
        }
        Map<String, File> fileMap = new HashMap<String, File>();
        fileMap.put(fileName, file);

        return _upload(fileMap).get(0);
    }



    private static void _check(Map<String, File> fileMap) {

        for (File file : fileMap.values()) {
            if (!file.exists()) {
                throw new RuntimeException("文件[" + file.getName() + "]不存在");
            }
        }
    }



    private static String getFileKey(String fileAbsolutePath) {

        if (StringUtils.isNullOrEmpty(fileAbsolutePath)) {
            return null;
        }
        return fileAbsolutePath.substring(fileAbsolutePath.indexOf(AliUploaderAuth.getBucketUrl()) + AliUploaderAuth.getBucketUrl().length() + 1);
    }



    /**
     * 删除单个文件
     *
     * @param fileAbsolutePath 文件存储在oss上的绝对路径 如http://hydeecloud.oss-cn-shanghai.aliyuncs.com/upload/1572831521357-temp.jpg
     * @return
     */
    public static boolean deleteFile(String fileAbsolutePath) {

        return getOperate().deleteObject(AliUploaderAuth.getBucketName(), getFileKey(fileAbsolutePath));
    }



    /**
     * 批量删除文件
     *
     * @param fileAbsolutePathList
     * @return
     */
    public static int deleteFiles(List<String> fileAbsolutePathList) {

        if (fileAbsolutePathList != null || fileAbsolutePathList.size() < 1) {
            return 0;
        }
        fileAbsolutePathList.stream().forEach(string -> {
            string = getFileKey(string);
        });
        return getOperate().deleteObjects(fileAbsolutePathList, AliUploaderAuth.getBucketName());
    }



    /**
     * 生成临时的文件访问url
     *
     * @param filePath 文件存储在oss上的相对位置
     * @param expired  访问改文件的url临时过期时间
     * @return
     */
    public static String generateTempUrl(String filePath, Date expired) {

        return getOperate().getUrl(AliUploaderAuth.getBucketName(), filePath, expired);
    }



    /**
     * 下载文件
     *
     * @param fileAbsolutePath 文件存储在oss上的绝对路径 如http://hydeecloud.oss-cn-shanghai.aliyuncs.com/upload/1572831521357-temp.jpg
     * @return
     */
    public static InputStream downloadFile(String fileAbsolutePath) {

        return getOperate().getObject(AliUploaderAuth.getBucketName(), getFileKey(fileAbsolutePath));
    }



    /**
     * 下载文件
     *
     * @param fileAbsolutePath
     * @param file
     * @return
     */
    public static boolean downLoadFile(String fileAbsolutePath, File file) {

        GetObjectRequest getObjectRequest = new GetObjectRequest(AliUploaderAuth.getBucketName(), getFileKey(fileAbsolutePath));
        return getOperate().getObject(getObjectRequest, file);
    }



    /**
     * 设置上传文件的访问权限
     *
     * @param filePath
     * @param fileName
     * @param inputStream
     * @param fileAcl     OssFileAclEnums枚举类 0 1 2 3
     * @return
     */
    public static String putObjectAcl(String filePath, String fileName, InputStream inputStream, int fileAcl) {

        String key = filePath + "/" + fileName;
        PutObjectRequest putObjectRequest = new PutObjectRequest(AliUploaderAuth.getBucketName(), key, inputStream);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setObjectAcl(OssFileAclEnums.getInstance(fileAcl).getValue());
        putObjectRequest.setMetadata(objectMetadata);
        if (getOperate().putObject(putObjectRequest)) {
            return AliUploaderAuth.getBucketUrl() + "/" + key;
        }
        return null;
    }



    public static String putObject(String filePath, String fileName, InputStream inputStream) {

        return putObjectAcl(filePath, fileName, inputStream, OssFileAclEnums.Default.getType());
    }



    /**
     * 列出当前文件夹下所有文件集合
     *
     * @param directory 指定目录 upload或者upload/
     * @return
     */
    public static List<String> listDirFiles(String directory) {

        if (StringUtils.isNullOrEmpty(directory)) {
            return null;
        }
        if (!directory.endsWith("/")) {
            directory = directory + "/";
        }
        return getOperate().listObjects(AliUploaderAuth.getBucketName(), directory);
    }



    /**
     * 图片处理 默认当前bucketName
     *
     * @param originImagePath
     * @param originImageName
     * @param styleType
     * @param targetImagePath
     * @param targetImageName
     */
    public static String imageHandler(String originImagePath, String originImageName, String styleType, String targetImagePath, String targetImageName) {

        return imageHandler(AliUploaderAuth.getBucketName(), originImagePath, originImageName, styleType, targetImagePath, targetImageName);
    }



    /**
     * 图片处理 指定bucketName
     *
     * @param bucketName
     * @param originImagePath
     * @param originImageName
     * @param styleType
     * @param targetImagePath
     * @param targetImageName
     */
    public static String imageHandler(String bucketName, String originImagePath, String originImageName, String styleType, String targetImagePath, String targetImageName) {

        String key = originImagePath + "/" + originImageName;
        String target = targetImagePath + "/" + targetImageName;
        StringBuilder sbStyle = new StringBuilder();
        Formatter styleFormatter = new Formatter(sbStyle);
        styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                BinaryUtil.toBase64String(target.getBytes()),
                BinaryUtil.toBase64String(bucketName.getBytes()));
        ProcessObjectRequest processObjectRequest = new ProcessObjectRequest(bucketName, key, sbStyle.toString());
        getOperate().imgaeHandler(processObjectRequest);
        return AliUploaderAuth.getBucketUrl() + "/" + target;
    }



    private static IFileOperate getOperate() {

        return new AliFileOperate();
    }


}
