package com.fast.trade.util.alioss.enums;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/12/9 11:55
 * @decription: 阿里文件处理类型
 */
public enum OssImageStyleEnums {
    /**
     * 缩放
     */
    resize("image/resize"),
    /**
     * 裁剪
     */
    crop("image/crop"),
    /**
     * 旋转
     */
    rotate("image/rotate"),
    /**
     * 锐化
     */
    sharpen("image/sharpen"),
    /**
     * 水印
     */
    watermark("image/watermark"),
    /**
     * 格式转换
     */
    format("image/format"),
    /**
     * 获取图片信息
     */
    info("image/info");
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    OssImageStyleEnums(String name) {
        this.name = name;
    }
}
