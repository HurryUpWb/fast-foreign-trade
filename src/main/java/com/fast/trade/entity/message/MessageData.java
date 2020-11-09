package com.fast.trade.entity.message;


import com.fast.trade.entity.enums.IMessageEnum;
import com.fast.trade.entity.enums.MessageEnum;

/**
 *@author 接口返回对象模板
 *@author 添加，修改，删除等接口请求返回模板
 *@author 接口业务返回信息包含在data内 ，即接口内部返回业务执行结果以及需要返回的值都在data里
 *
 */
public class MessageData<T> extends Message {
	
	private static final long serialVersionUID = 1001001L;
	
	
	public  MessageData(){
	
	}
	
	public  MessageData(MessageData<?> messageData){
		this(messageData,null);
	}
	
	public  MessageData(MessageData<?> messageData, T data){
		setSuccess(messageData.isSuccess());
		setBizSuccess(messageData.isBizSuccess());
		setCode(messageData.getCode());
		setMsg(messageData.getMsg());
		setData(data);
	}

	public  MessageData(IMessageEnum messageEnum){
		setMessage(messageEnum);
	}



    public MessageData(boolean bizSuccess, String code, String msg, T data) {
        this.setBizSuccess(bizSuccess);
        this.setCode(code);
        this.setMsg(msg);
        this.data = data;
    }

	public static MessageData<Long>  getModMessage(long result) {
		if(result > 0){
			return success(MessageEnum.BIZ_MODIFY_SUCCESS, result);
		}
		return fail(MessageEnum.BIZ_MODIFY_FAIL, result);
	}

	public static MessageData<Long>  getModMessage(IMessageEnum message, long result) {
		return getModMessage(message.getCode(),message.getDisplayName(),result);
	}

	public static MessageData<Long>  getModMessage(String code, String message, long result) {
		if(result > 0){
			return success(code, message, result);
		}
		return fail(code, message, result);
	}
    
    public static <T>  MessageData<T>  fail(String code, String message) {
    	return fail(code, message, null);
    }
    
    public static <T>  MessageData<T>  fail(String code, String message, T data) {
    	return fail(false, code, message, data);
    }
    
    public static <T>  MessageData<T>  fail(boolean success, String code, String message, T data) {
    	return bulid(success, false, code, message, data);
    }
    
    public static <T>  MessageData<T>  fail(IMessageEnum messageEnum) {
    	return fail(false, messageEnum, null);
    }
    
    public static <T>  MessageData<T>  fail(IMessageEnum messageEnum, T data) {
    	return fail(false, messageEnum, data);
    }

    public static <T>  MessageData<T>  fail(boolean success, IMessageEnum messageEnum, T data) {
    	return bulid(success, false, messageEnum.getCode(), messageEnum.getDisplayName(), data);
    }

    public static <T> MessageData<T> success(IMessageEnum messageEnum) {
    	return success(messageEnum, null);
    }
    
    public static <T> MessageData<T> success(IMessageEnum messageEnum, T data) {
		return bulid(true, true,messageEnum.getCode(), messageEnum.getDisplayName(), data);
    }

	public static <T>  MessageData<T>  success(String code, String message, T data) {
		return bulid(true, true,code, message, data);
	}

    public static <T>  MessageData<T>  bulid(boolean success, boolean bizSuccess, String code,  String message, T data) {
    	MessageData<T>  messageData = new MessageData<T> ();
    	messageData.setCode(code);
    	messageData.setMsg(message);
    	messageData.setSuccess(success);
    	messageData.setBizSuccess(bizSuccess);
    	messageData.setData(data);
    	return messageData;
    }

	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public MessageData<T> msg(String msg) {
		setMsg(msg);
		return this;
	}

	
	public static final class Builder<T>{
		
		private boolean success;
		private boolean bizSuccess;
		private String msg;
		private String code;
		private T data;
		private IMessageEnum messageEnum;
		
		public Builder() {
		}
		
		public Builder(boolean success, boolean bizSuccess, String msg, String code, T data) {
			this.success = success;
			this.bizSuccess = bizSuccess;
			this.msg = msg;
			this.code = code;
			this.data = data;
		}
		
		public Builder<T> messageEnum(IMessageEnum messageEnum) {
			this.messageEnum = messageEnum;
			return this;
		}
		
		public Builder<T> success(boolean success) {
			this.success = success;
			return this;
		}
		
		public Builder<T> bizSuccess(boolean bizSuccess) {
			this.success = bizSuccess;
			return this;
		}
		
		public Builder<T> msg(String msg) {
			this.msg = msg;
			return this;
		}
		
		public Builder<T> code(String code) {
			this.code = code;
			return this;
		}
		
		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}
		
		public MessageData<T> build() {
			MessageData<T> messageData = new MessageData<T>();
			if(messageEnum != null){
				messageData.setMessage(messageEnum);
			}else{
				messageData = new MessageData<T>();
				messageData.setMsg(msg);
				messageData.setCode(code);
			}
			messageData.setSuccess(success);
			messageData.setBizSuccess(bizSuccess);
			messageData.setData(data);
			
			return messageData;
		}
		
	}
	 

}