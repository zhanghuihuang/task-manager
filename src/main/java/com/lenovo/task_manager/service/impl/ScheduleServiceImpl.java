package com.lenovo.task_manager.service.impl;

import com.lenovo.task_manager.dao.QuartzJobPlanConfigDao;
import com.lenovo.task_manager.entity.QuartzJobPlanConfig;
import com.lenovo.task_manager.service.QuartzJobManager;
import com.lenovo.task_manager.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/19 14:35
 */
@Service("scheduleService")
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private QuartzJobPlanConfigDao quartzJobPlanConfigDao;

    @Override
    public void startJob(String jobId) throws SchedulerException {
        QuartzJobPlanConfig jobPlanConfig = quartzJobPlanConfigDao.findById(jobId).orElse(null);
        Class<? extends Job> jobTaskExecutor=null;
        try {
            jobTaskExecutor = (Class<? extends Job>) Class.forName(jobPlanConfig.getClassName());
        } catch (ClassNotFoundException e) {
            jobPlanConfig.setStatus(false);
            quartzJobPlanConfigDao.save(jobPlanConfig);
            return;
        }
        // 1、创建调度器Scheduler
        Scheduler scheduler = QuartzJobManager.getInstanceScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(jobTaskExecutor)
                .withIdentity(jobPlanConfig.getName(), jobPlanConfig.getName()).build();
        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobPlanConfig.getName(), jobPlanConfig.getName())
                .startNow()//立即生效
                .withSchedule(CronScheduleBuilder.cronSchedule(jobPlanConfig.getCronExpression())).build();//一直执行
        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void stopJob(String jobId) throws SchedulerException {
        QuartzJobPlanConfig jobPlanConfig = quartzJobPlanConfigDao.findById(jobId).orElse(null);
        Scheduler scheduler = QuartzJobManager.getInstanceScheduler();
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobPlanConfig.getName(),jobPlanConfig.getName()));
    }

    @Override
    public boolean isRunning(String jobId) {
        QuartzJobPlanConfig jobPlanConfig = quartzJobPlanConfigDao.findById(jobId).orElse(null);
        Scheduler scheduler = QuartzJobManager.getInstanceScheduler();
        return false;
    }
}
