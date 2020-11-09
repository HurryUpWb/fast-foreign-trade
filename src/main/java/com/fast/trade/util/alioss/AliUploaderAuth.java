package com.fast.trade.util.alioss;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/10/27 14:26
 * @decription: oss服务器参数
 */
@Configuration
public class AliUploaderAuth {

    private  static String endPoint;


    private  static String bucketName;


    private  static String accessKeyId;


    private  static String accessKeySecret;

    private static String bucketUrl;

    @Value("${ali.oss.endPoint}")
    public void setEndPoint(String endPoint) {
        AliUploaderAuth.endPoint = endPoint;
    }

    @Value("${ali.oss.bucketName}")
    public void setBucketName(String bucketName) {
        AliUploaderAuth.bucketName = bucketName;
    }

    @Value("${ali.oss.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        AliUploaderAuth.accessKeyId = accessKeyId;
    }

    @Value("${ali.oss.accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        AliUploaderAuth.accessKeySecret = accessKeySecret;
    }

    @Value("${ali.oss.bucketUrl}")
    public void setBucketUrl(String bucketUrl) {
        AliUploaderAuth.bucketUrl = bucketUrl;
    }
    public static String getBucketUrl() {
        return bucketUrl;
    }
    public static String getEndPoint() {
        return endPoint;
    }

    public static String getBucketName() {
        return bucketName;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }
}
