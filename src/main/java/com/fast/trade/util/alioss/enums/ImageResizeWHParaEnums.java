package com.fast.trade.util.alioss.enums;

/**
 * Copyright (C), 2015-2019, 上海海典软件有限公司
 *
 * @author: lxf
 * @date: 2019/12/9 14:18
 * @decription: 图片缩放类型的参数
 */
public enum ImageResizeWHParaEnums {
    /**
     * 等比缩放，限制在指定w和h的矩形内的最大图片(默认)
     */
    m_lfit("m_lfit"),

    /**
     * 等比缩放，延伸出指定w和h的矩形框外的最小图片
     */
    m_mfit("m_mfit"),

    /**
     * 固定宽高，将延伸出指定w与h的矩形框外的最小图片进行居中裁剪。
     */
    m_fill("m_fill"),

    /**
     * 固定宽高，缩略填充
     */
    m_pad("m_pad"),

    /**
     * 固定宽高，强制缩略
     */
    m_fixed("m_fixed"),

    /**
     * 指定目标缩略图的宽度（1-4096）
     */
    w_("w_"),

    /**
     * 指定目标缩略图的高度（1-4096）
     */
    h_("h_"),

    /**
     * 指定目标缩略图的最长边（1-4096）
     */
    l_("l_"),

    /**
     * 指定目标缩略图的最短边（1-4096）
     */
    s_("s_"),

    /**
     * 指定当目标缩略图大于原图时是否处理。值是 1 表示不处理；值是 0 表示处理(0/1, 默认是 1)
     */
    limit_("limit_"),

    /**
     * 当缩放模式选择为 pad（缩略填充）时，可以选择填充的颜色(默认是白色)参数的填写方式：采用 16 进制颜色码表示，如 00FF00（绿色）范围[000000-FFFFFF]
     */
    color_("color_"),

    /**
     * 倍数百分比。 小于 100，即是缩小，大于 100 即是放大(1-1000)
     */
    p_("p_");
    private String value;

    ImageResizeWHParaEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
