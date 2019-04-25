package com.lenovo.task_manager.enums;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/19 9:17
 */
public enum JobTaskStatusEnum {
    FAIL(0,"FAIL","执行失败"),
    SUCCESS(1,"SUCCESS","执行成功"),
    RUNNING(2,"RUNNING","执行中");
    private int value;
    private String name;
    private String info;

    JobTaskStatusEnum(int value, String name, String info) {
        this.value = value;
        this.name = name;
        this.info = info;
    }}
