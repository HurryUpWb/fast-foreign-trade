package com.fast.trade.entity.enums;

/**
 * 抽象异常定义
 * @author WangJie
 */
public interface IMessageEnum {

    /**
     * 状态code
     * @return code
     */
    public String getCode();

    /**
     * 错误说明
     * @return 错误说明
     */
    public String getName();

    /**
     * 错误说明简单易懂版本
     * @return 错误说明简单易懂版本
     */
    public String getDisplayName();


}
