package com.lenovo.task_manager.exception;

import lombok.Data;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/20 15:49
 */
@Data
public class BusinessException extends RuntimeException {
    public BusinessException(int code,String message,String... args){
        super(String.format(message,args));
        this.code=code;
    }

    public BusinessException(int code,Throwable cause,String message,String... args) {
        super(String.format(message,args), cause);
        this.code=code;
    }

    private int code;

    public static BusinessException newInstance(ResultCode resultCode,String... args){
        return new BusinessException(resultCode.getCode(),resultCode.getMessage_cn(),args);
    }

    public static BusinessException newInstance(ResultCode resultCode,Throwable cause,String... args){
        return new BusinessException(resultCode.getCode(),cause,resultCode.getMessage_cn(),args);
    }
}
