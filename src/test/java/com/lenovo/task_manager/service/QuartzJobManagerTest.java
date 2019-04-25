package com.lenovo.task_manager.service;

import com.lenovo.task_manager.job.Task1;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.quartz.*;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/22 15:43
 */
@Slf4j
public class QuartzJobManagerTest {

    @Test
    public void getInstanceScheduler() {
    }

    @Test
    public void getSchedulerName() {
        QuartzJobManager.start();
        log.info(QuartzJobManager.getSchedulerName());
    }

    @Test
    public void getSchedulerInstanceId() {
    }

    @Test
    public void getContext() {
    }

    @Test
    public void start() {
    }

    @Test
    public void startDelayed() {
    }

    @Test
    public void isStarted() {
    }

    @Test
    public void standby() {
    }

    @Test
    public void isShutdown() {
    }

    @Test
    public void getMetaData() {
    }

    @Test
    public void getCurrentlyExecutingJobs() {
    }

    @Test
    public void shutdown() {
    }

    @Test
    public void shutdown1() {
    }

    @Test
    public void scheduleJob() throws InterruptedException {
        QuartzJobManager.start();
        //cron表达式格式：{秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
        JobDetail jobDetail = JobBuilder.newJob(Task1.class)
                .withIdentity("task1", "task1").build();
        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("task1-1", "task1")
                .startNow()//立即生效
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();//一直执行
        QuartzJobManager.scheduleJob(jobDetail, trigger);
        Thread.sleep(10000L);
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("task1-2", "task1")
                .forJob(jobDetail)
                .startNow()//立即生效
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();//一直执行
        QuartzJobManager.scheduleJob(trigger1);
        Thread.sleep(10000L);
        QuartzJobManager.pauseTrigger(TriggerKey.triggerKey("task1-2", "task1"));
        Thread.sleep(25000L);
        System.out.println("继续\"task1-2\", \"task1\"");
        QuartzJobManager.resumeTrigger(TriggerKey.triggerKey("task1-2", "task1"));
        Thread.sleep(25000L);
    }

    @Test
    public void scheduleJob1() {
    }

    @Test
    public void unscheduleJob() {
    }

    @Test
    public void rescheduleJob() {
    }

    @Test
    public void addJob() {
    }

    @Test
    public void addJob1() {
    }

    @Test
    public void deleteJob() {
    }

    @Test
    public void deleteJobs() {
    }

    @Test
    public void triggerJob() {
    }

    @Test
    public void triggerJob1() {
    }

    @Test
    public void pauseJob() {
    }

    @Test
    public void pauseJobs() {
    }

    @Test
    public void pauseTrigger() {
    }

    @Test
    public void pauseTriggers() {
    }

    @Test
    public void resumeJob() {
    }

    @Test
    public void resumeJobs() {
    }

    @Test
    public void resumeTrigger() {
    }

    @Test
    public void resumeTriggers() {
    }

    @Test
    public void pauseAll() {
    }

    @Test
    public void resumeAll() {
    }

    @Test
    public void getJobGroupNames() {
    }

    @Test
    public void getJobKeys() {
    }

    @Test
    public void getTriggersOfJob() {
    }

    @Test
    public void getTriggerGroupNames() {
    }

    @Test
    public void getTriggerKeys() {
    }

    @Test
    public void getPausedTriggerGroups() {
    }

    @Test
    public void getJobDetail() {
    }

    @Test
    public void getTrigger() {
    }

    @Test
    public void getTriggerState() {
    }

    @Test
    public void resetTriggerFromErrorState() {
    }

    @Test
    public void addCalendar() {
    }

    @Test
    public void deleteCalendar() {
    }

    @Test
    public void getCalendar() {
    }

    @Test
    public void getCalendarNames() {
    }

    @Test
    public void interrupt() {
    }

    @Test
    public void interrupt1() {
    }

    @Test
    public void checkExists() {
    }

    @Test
    public void checkExists1() {
    }

    @Test
    public void clear() {
    }
}