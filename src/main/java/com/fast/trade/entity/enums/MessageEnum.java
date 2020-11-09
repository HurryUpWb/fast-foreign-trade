package com.fast.trade.entity.enums;

/**
 * @author 消息提示
 * @Code 值每个模块用五位数字
 * @name 英文提示
 * @displayName 中文提示
 */
public enum MessageEnum implements IMessageEnum {

    //00000 标识未知
    NONE("00000", "NONE", "未知"),

    //业务执行成功，查询不到数据，但是如果没有报错也是查询成功
    BIZ_ADD_SUCCESS("00101", "biz add success", "添加成功！"),
    BIZ_DEL_SUCCESS("00102", "biz del success", "删除成功！"),
    BIZ_MODIFY_SUCCESS("00103", "biz modify success", "修改成功！"),
    BIZ_OPERATION_SUCCESS("00104", "operation success", "操作成功！"),


    //业务执行失败，非参数判断失败，只是业务执行过程中插入数据失败（业务执行失败，可以使用各自定义的返回）
    BIZ_ADD_FAIL("00001", "biz add fail", "添加失败！"),
    BIZ_DEL_FAIL("00002", "biz del fail", "删除失败！"),
    BIZ_MODIFY_FAIL("00003", "biz modify fail", "修改失败！"),
    BIZ_QUERY_FAIL("00004", "biz query fail", "查询失败！"),
    BIZ_PARAMETER_ERROR("00006", "biz parameter error", "参数错误！"),
    BIZ_OPERATION_FAIL("00007", "operation fail", "操作错误！"),

    //业务执行异常，因为文件不存在，网络异常，或调用超时导致的异常
    BIZ_ADD_EXCEPTION("00401", "biz add fail", "添加异常！"),
    BIZ_DEL_EXCEPTION("00402", "biz del fail", "删除异常！"),
    BIZ_MODIFY_EXCEPTION("00403", "biz modify fail", "修改异常！"),
    BIZ_QUERY_EXCEPTION("00404", "biz query fail", "查询异常！"),
    BIZ_CONNECT_EXCEPTION("00405", "biz connect fail", "连接异常！"),


    BIZ_EXCEPTION("00406", "biz exception", "业务执行异常！"),

    //参数相关
    BIZ_PARAM_ERR("00501", "param err", "参数错误！"),
    BIZ_PARAM_MISSING("00502", "param missing", "缺少参数！"),
    BIZ_PARAM_TYPE_ERR("00503", "param type err", "参数类型错误！"),
    BIZ_PARAM_NONE("00504", "param none", "参数为空！"),
    BIZ_LOGIN_ERROR("00505", "login error", "获取登录信息失败"),

    //查询相关
    BIZ_QUERY_SUCCESS("00600", "biz query success", "查询成功！"),
    BIZ_QUERY_ERROR("00601", "query err", "查询失败！"),
    BIZ_QUERY_NO_RESULT("00602", "no result", "没有查询结果！"),
    BIZ_QUERY_Y_EXIST("00603", "exists", "已存在！"),

    //产品相关
    PRODUCT_EXISTS("11000","product exists","当前产品编码已被占用！"),

    //用户相关
    USER_ACCOUNT_EXISTS("12000","account exists","账号已存在！"),
    USER_ACCOUNT_NOT_EXISTS("12001","account not exists","账号不存在！"),
    USER_REGIST_SUCCESS("12002","regist success","账号注册成功！"),
    USER_REGIST_FAIL("12003","regist fail","账号注册失败！"),
    USER_INFO_NOT_EXISTS("12004","user info not exists","用户信息不存在！"),
    USER_LOGIN_SUCCESS("12005","user login success","登录成功！"),


    ;


    private String code;
    private String name;
    private String displayName;

    MessageEnum(String code, String name, String displayName) {
        this.code = code;
        this.name = name;
        this.displayName = displayName;
    }

    public static MessageEnum findMessageByValue(String code) {
        MessageEnum[] values = MessageEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getCode() == code) {
                return values[i];
            }
        }
        return MessageEnum.NONE;
    }

    public static String getMessageDisplayNameByValue(String code) {
        MessageEnum[] values = MessageEnum.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getCode() == code) {
                return values[i].getDisplayName();
            }
        }
        return MessageEnum.NONE.getDisplayName();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }


}
