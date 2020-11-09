package com.fast.trade.entity.message;


import com.fast.trade.entity.enums.IMessageEnum;
import com.fast.trade.entity.enums.MessageEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.github.pagehelper.Page;


/**
 *@author 查询接口返回模板（有分页时使用该模板）
 *@author dataList 为接口查询数据集合，默认空List
 *@author resultMap 当有额外信息时，存放该信息。默认空Map
 *@author pageIndex 分页第几页 （从第一页开始，内部会自动控制-1）
 *@author pageSize 分页每页几条数据（默认20） 
 *@author pageCount 总共多少页
 */
public class  MessageQuery<T> extends Message {
	
	private static final long serialVersionUID = 100101L;
	
	public MessageQuery(IMessageEnum messageEnum){
		super(messageEnum);
	}
	
	public MessageQuery(){
		super(MessageEnum.NONE);
	}
	
/*	public MessageQuery(MessageEnum messageEnum,Page<T> page, boolean bizSuccess){
		super(messageEnum);
		setBizSuccess(bizSuccess);
		setPageSize(page.getPageSize());
		setTotalCount(page.getTotal());
		setPageIndex(page.getPageNum());
		setDataList(page.getResult());
	}*/
	
	public MessageQuery(MessageQuery<?> messageQuery){
		this(messageQuery, null);
	}
	
	public MessageQuery(MessageQuery<?> messageQuery, List<T> dataList){
		
		setSuccess(messageQuery.isSuccess());
		setBizSuccess(messageQuery.isBizSuccess());
		setCode(messageQuery.getCode());
		setMsg(messageQuery.getMsg());
		setPageSize(messageQuery.getPageSize());
		setTotalCount(messageQuery.getTotalCount());
		setResultMap(messageQuery.getResultMap());
		setPageIndex(messageQuery.getPageIndex());
		setCurrentTimeMillis(messageQuery.getCurrentTimeMillis());
		setDataList(dataList);
	}
	
	public MessageQuery(int pageSize){
		super(MessageEnum.NONE);
		this.pageSize=pageSize;
	}
	
	public static <T> MessageQuery<T> fail(IMessageEnum messageEnum) {
    	return fail(false, messageEnum, new ArrayList<T>());
    }

	public static <T> MessageQuery<T> fail(String code, String msg) {
		MessageQuery<T> messageData = new MessageQuery<T>();
		messageData.setBizSuccess(false);
		messageData.setCode(code);
		messageData.setMsg(msg);
		return messageData;
	}
    
    public static <T> MessageQuery<T> fail(IMessageEnum messageEnum, List<T> dataList) {
    	return fail(false, messageEnum, dataList);
    }
    
    public static <T> MessageQuery<T> fail(boolean success, IMessageEnum messageEnum, List<T> dataList) {
    	 MessageQuery<T> messageData = new MessageQuery<T>(messageEnum);
    	messageData.setSuccess(success);
    	messageData.setBizSuccess(false);
    	messageData.setDataList(dataList);
    	return messageData;
    }
    
	public static <T> MessageQuery<T> success(IMessageEnum messageEnum) {
    	return success(messageEnum, new ArrayList<T>());
    }

	public static <T> MessageQuery<T> success(String code, String msg, List<T> dataList) {
		MessageQuery<T> messageData = new MessageQuery<T>();
		messageData.setCode(code);
		messageData.setMsg(msg);
		messageData.setBizSuccess(true);
		messageData.setDataList(dataList);
		return messageData;
	}

    public static <T> MessageQuery<T> success(IMessageEnum messageEnum, List<T> dataList) {
    	MessageQuery<T> messageData = new MessageQuery<T>(messageEnum);
    	messageData.setBizSuccess(true);
    	messageData.setDataList(dataList);
    	return messageData;
    }
    
	public MessageQuery<T> pageIndex(long pageIndex) {
//		this.setPageIndex(pageIndex);
		this.pageIndex = pageIndex - 1;
		return this;
	}
	
	public MessageQuery<T> pagePageSize(int pageSize) {
		this.setPageSize(pageSize);
		return this;
	}
	
	public MessageQuery<T> totalCount(long totalCount) {
		this.setTotalCount(totalCount);
		return this;
	}
	
	private List<T> dataList;
	
	private Map<String, Object> resultMap;

	private long pageIndex = 1L; //页数(页码)
	
	private long totalCount; //查询结果的总数
	
	private int pageSize = 20;//一页显示的行数
	
	private long pageCount;//总页数
	
    public boolean isNotEmpty() {
        return this.isBizSuccess() && this.getDataList() != null;
    }
	
	public List<T> getDataList() {
		if(dataList == null){
			dataList = new ArrayList<T>();
		}
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public long getPageIndex() {
		return pageIndex + 1;
	}

	public void setPageIndex(long pageIndex) {
		
		if(pageIndex > this.pageCount){
			pageIndex = this.pageCount;
		}
		
		if(pageIndex < 1){
			pageIndex = 1;
		}
		
		this.pageIndex = pageIndex - 1;
	}
	
	public void setTruePageIndex(long pageIndex) {
		this.pageIndex = pageIndex-1;
	}

	public long getTotalCount() {
		return totalCount;
	}
	
	/**
	 * 
	 * @param totalCount
	 * 设置总数时自动计算总页数
	 * 通过pageIndex重置第几条查询
	 * 
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		this.pageCount = this.totalCount / this.pageSize + ( this.totalCount % this.pageSize == 0 ? 0 : 1);
	
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * 重置分页数
	 * 重新计算总页数
	 * 通过pageIndex重置第几条查询
	 * 
	 */
	public void setPageSize(int pageSize) {
		if( pageSize < 1){
			return;
		}
		this.pageSize = pageSize;
		this.pageCount = this.totalCount / this.pageSize + (this.totalCount % this.pageSize == 0 ? 0 : 1);
		//if(limitIndex!=0)this.pageIndex=this.limitIndex/pageSize;
		
	}

	public long getPageCount() {
		return pageCount;
	}

	public Map<String,Object> getResultMap() {
		if(resultMap == null){
			resultMap = new HashMap<String, Object>();
		}
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
public static final class MessageQueryBuilder<T>{
		
		private boolean success;
		private boolean bizSuccess;
		private String msg;
		private String code;
		private List<T> dataList;
		private Map<String,Object> resultMap;
		private long pageIndex; //页数(页码)
		private long totalCount; //查询结果的总数
		private int pageSize = 20;//一页显示的行数
		private IMessageEnum messageEnum;
		
		public MessageQueryBuilder() {
		}
		
		public MessageQueryBuilder(boolean success, boolean bizSuccess, String msg, String code, List<T> dataList,Map<String,Object> resultMap,
													  long pageIndex,int pageSize,long totalCount) {
			this.success = success;
			this.bizSuccess = bizSuccess;
			this.msg = msg;
			this.code = code;
			this.dataList = dataList;
			this.resultMap = resultMap;
			this.pageIndex = pageIndex;
			this.pageIndex = pageSize;
			this.totalCount = totalCount;
		}
		
		public MessageQueryBuilder<T> messageEnum(IMessageEnum messageEnum) {
			this.messageEnum = messageEnum;
			return this;
		}
		
		public MessageQueryBuilder<T> success(boolean success) {
			this.success = success;
			return this;
		}
		
		public MessageQueryBuilder<T> bizSuccess(boolean bizSuccess) {
			this.success = bizSuccess;
			return this;
		}
		
		public MessageQueryBuilder<T> msg(String msg) {
			this.msg = msg;
			return this;
		}
		
		public MessageQueryBuilder<T> code(String code) {
			this.code = code;
			return this;
		}
		
		public MessageQueryBuilder<T> dataList(List<T> dataList) {
			this.dataList = dataList;
			return this;
		}
		
		public MessageQueryBuilder<T> resultMap(Map<String,Object> resultMap) {
			this.resultMap = resultMap;
			return this;
		}
		
		public MessageQueryBuilder<T> pageIndex(long pageIndex) {
			this.pageIndex = pageIndex;
			return this;
		}
		
		public MessageQueryBuilder<T> pageSize(int pageSize) {
			this.pageSize = pageSize;
			return this;
		}
		
		public MessageQueryBuilder<T> totalCount(long totalCount) {
			this.totalCount = totalCount;
			return this;
		}
		
		public MessageQuery<T> build() {
			
			MessageQuery<T> messageQuery = new MessageQuery<T>();
			if(messageEnum != null){
				messageQuery .setMessage(messageEnum);
			}else{
				messageQuery.setMsg(msg);
				messageQuery.setCode(code);
			}
			messageQuery.setSuccess(success);
			messageQuery.setBizSuccess(bizSuccess);
			messageQuery.setDataList(dataList);
			messageQuery.setResultMap(resultMap);
			messageQuery.setPageIndex(pageIndex);
			messageQuery.setPageSize(pageSize);
			messageQuery.setTotalCount(totalCount);
			return messageQuery;
			
		}
		
	}

}