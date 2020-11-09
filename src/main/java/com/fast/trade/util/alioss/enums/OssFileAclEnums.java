package com.fast.trade.util.alioss.enums;

import com.aliyun.oss.model.CannedAccessControlList;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/12/4 15:05
 * @decription:
 */
public enum  OssFileAclEnums {
    Default(0,CannedAccessControlList.Default),
    Private(1,CannedAccessControlList.Private),
    PublicRead(2,CannedAccessControlList.PublicRead),
    PublicReadWrite(3,CannedAccessControlList.PublicReadWrite);
    private int type;
    private CannedAccessControlList value;

    OssFileAclEnums(int type, CannedAccessControlList value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public CannedAccessControlList getValue() {
        return value;
    }

    public void setValue(CannedAccessControlList value) {
        this.value = value;
    }

    public static OssFileAclEnums getInstance(int type){
        OssFileAclEnums[] values = OssFileAclEnums.values();
        //必须严格按照顺序写否则不能使用此种方式
        if (type >= 0 && type < values.length) {
            return values[type];
        }

        return OssFileAclEnums.Default;
    }

}
