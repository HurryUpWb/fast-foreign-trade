package com.fast.trade.handel;

import com.fast.trade.entity.enums.MessageEnum;
import com.fast.trade.entity.message.MessageData;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class ExceptionMassageBuilder {

    public static MessageData<Object> getErrorInfo(Throwable error){

        MessageData<Object> resultInfo = new MessageData<>();
        resultInfo.setSuccess(false);
        resultInfo.setBizSuccess(false);

        // 方法参数类型参数校验异常
        if (error instanceof MethodArgumentNotValidException) {
            resultInfo.setCode(MessageEnum.BIZ_PARAMETER_ERROR.getCode());
            resultInfo.setMsg(getArgumentNotValidMsg((MethodArgumentNotValidException) error));
            return resultInfo;
        }
        //参数校验异常
        if (error instanceof MissingServletRequestParameterException) {
            resultInfo.setCode(MessageEnum.BIZ_PARAMETER_ERROR.getCode());
            resultInfo.setMsg(getParameterExceptionMsg((MissingServletRequestParameterException) error));
            return resultInfo;
        }

        //其他异常
        resultInfo.setMessage(MessageEnum.BIZ_EXCEPTION);
        return resultInfo;
    }

    public static String getExceptionAllInformation(Throwable e){
        StringWriter sw = new StringWriter();   
        PrintWriter pw = new PrintWriter(sw, true);   
        e.printStackTrace(pw);   
        pw.flush();   
        sw.flush();   
        return sw.toString();   
    } 
    
    public static String getExceptionInformation(Throwable e){   
        return e.toString();   
    } 


    private static String getParameterExceptionMsg(MissingServletRequestParameterException exception) {
        StringBuilder msgBuffer = new StringBuilder();
        if(exception == null) {
            return msgBuffer.toString();
        }
        return msgBuffer.append(exception.getMessage()).toString();


    }
    private static String getArgumentNotValidMsg(MethodArgumentNotValidException exception) {
    	
    	StringBuffer msgBuffer = new StringBuffer();
    	if(exception == null) {
    		return msgBuffer.toString();
    	}
        BindingResult bindingResult = exception.getBindingResult();
        if (!bindingResult.hasErrors()) {
        	return msgBuffer.toString();
        }
        List<FieldError> list = bindingResult.getFieldErrors();
        handelArgumentErrorMsg(list, msgBuffer);
        return msgBuffer.toString();
    }
    
    private static void handelArgumentErrorMsg(List<FieldError> list, StringBuffer msg) {
        FieldError fieldError = list.get(0);
        msg.append(fieldError.getDefaultMessage());
    }


}