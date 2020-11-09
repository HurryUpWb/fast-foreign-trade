package com.fast.trade.handel;

import com.fast.trade.entity.message.MessageData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @title: ResultResponseBodyAdvice
 * @package com.fast.trade
 * @description:
 * @author: wangbo
 * @date: 2020/6/22 15:08
 * @version: V1.0
 */
@ControllerAdvice
public class ResultResponseBodyAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MessageData<Object> handlerException(HttpServletRequest request, Exception ex) {

        return ExceptionMassageBuilder.getErrorInfo(ex);
    }

}
