package com.fast.trade.util.alioss.enums;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/12/9 14:10
 * @decription: 图片缩放类型
 */
public enum ImageResizeType {
    //按照指定宽高缩放
    width_height(1),
    //按照比例缩放
    percentage(2);
    private int type;

    ImageResizeType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
