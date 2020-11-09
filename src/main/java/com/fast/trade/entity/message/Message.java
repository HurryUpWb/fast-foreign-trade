package com.fast.trade.entity.message;

import com.fast.trade.entity.enums.IMessageEnum;

import java.io.Serializable;


/**
 *@author  接口返回消息模板类
 *@author success 接口请求是否成功（包含验证时，验证失败则返回false，进入内部业务逻辑处理之后都返回true）
 *@author bizSuccess 业务执行结果(业务执行结果) 
 *@author code 接口请求返回接口状态code
 *@author msg 接口请求返回接口状态消息描述
 */
public class Message implements Serializable {
	
	private static final long serialVersionUI = 1008611L;
	
	public Message(){
	}
	
	public Message(IMessageEnum messageEnum){
		setMessage(messageEnum);
	}

    /**
     * 成功状态
     */
	private boolean success;
    /**
     * 成功状态
     */
	private boolean bizSuccess;

    /**
     * 请求说明
     */
	private String msg;

    /**
     * 请求code
     */
	private String code;
	
	private long currentTimeMillis = System.currentTimeMillis();

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isBizSuccess() {
		return bizSuccess;
	}
	public void setBizSuccess(boolean bizSuccess) {
		if(bizSuccess) {
			this.setSuccess(bizSuccess);
		}
		this.bizSuccess = bizSuccess;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}

	public long getCurrentTimeMillis() {
		return currentTimeMillis;
	}
	
	public void setCurrentTimeMillis(long currentTimeMillis) {
		this.currentTimeMillis = currentTimeMillis;
	}
	
	public void setMessage(IMessageEnum message){
		if(message == null){
			return;
		}
		this.code = message.getCode();
		this.msg = message.getDisplayName();
	}
	
	
}