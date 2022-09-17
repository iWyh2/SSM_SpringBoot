package com.wyh.controller.exception;

import com.wyh.controller.code.Code;
import com.wyh.controller.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//为REST风格的控制器做增强功能的注解
public class ProjectExceptionAdvice{
    @ExceptionHandler(SystemException.class)//异常处理器
    public Result doSystemException(SystemException e) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员。e对象也发给开发人员
        return new Result(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)//异常处理器
    public Result doBusinessException(BusinessException e) {
        return new Result(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)//处理其他未知异常
    public Result doException(Exception e) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员。e对象也发给开发人员
        return new Result(Code.UNKNOWN_ERR,"系统繁忙，请稍后再试");
    }
}
