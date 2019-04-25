package com.lenovo.task_manager.service;

import org.quartz.SchedulerException;

/**
 * 调度服务接口
 */
public interface ScheduleService {

    /**
     * 启动job
     * @param jobId
     */
    void startJob(String jobId) throws SchedulerException;

    /**
     * 停止job
     * @param jobId
     */
    void stopJob(String jobId) throws SchedulerException;

    /**
     * 是否存在运行中job
     * @param jobId
     * @return
     */
    boolean isRunning(String jobId);

}
