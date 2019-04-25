package com.lenovo.task_manager.exception;

import lombok.Getter;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/20 15:54
 */
@Getter
public enum ResultCode {
    SCHEDULE_ERROR(510,"schedule error:%s","定时任务调度异常:%s");

    private int code;
    private String message_en;
    private String message_cn;

    ResultCode(int code, String message_en, String message_cn) {
        this.code = code;
        this.message_en = message_en;
        this.message_cn = message_cn;
    }
}
