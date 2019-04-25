package com.lenovo.task_manager.service;

import com.lenovo.task_manager.exception.BusinessException;
import com.lenovo.task_manager.exception.ResultCode;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/19 16:56
 */
public class QuartzJobManager{
    private static Scheduler scheduler = getScheduler();

    /**
     * 创建一个调度对象
     *
     * @return
     * @throws SchedulerException
     */
    private static Scheduler getScheduler() {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = sf.getScheduler();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "schedulerFactory.getScheduler 异常");
        }
        return scheduler;
    }

    public static Scheduler getInstanceScheduler() {
        return scheduler;
    }

    /**
     * 获取调度器的名称
     * @return
     */
    public static String getSchedulerName() {
        try {
            return scheduler.getSchedulerName();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getSchedulerName 异常");
        }
    }

    public static String getSchedulerInstanceId() {
        try {
            return scheduler.getSchedulerName();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getSchedulerName 异常");
        }
    }


    public static SchedulerContext getContext() {
        try {
            return scheduler.getContext();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getContext 异常");
        }
    }

    public static void start() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.start 异常");
        }
    }


    public static void startDelayed(int seconds) {
        try {
            scheduler.startDelayed(seconds);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.startDelayed");
        }
    }

    public static boolean isStarted() {
        try {
            return scheduler.isStarted();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.isStarted 异常");
        }
    }


    public static void standby() {
        try {
            scheduler.standby();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.standby 异常");
        }
    }

    public static boolean isShutdown() {
        try {
            return scheduler.isShutdown();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.isShutdown 异常");
        }
    }


    public static SchedulerMetaData getMetaData() {
        try {
            return scheduler.getMetaData();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getMetaData 异常");
        }
    }


    public static List<JobExecutionContext> getCurrentlyExecutingJobs() {
        try {
            return scheduler.getCurrentlyExecutingJobs();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getCurrentlyExecutingJobs 异常");
        }
    }

    public static void shutdown() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.shutdown 异常");
        }
    }


    public static void shutdown(boolean waitForJobsToComplete) {
        try {
            scheduler.shutdown(waitForJobsToComplete);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.shutdown 异常");
        }
    }

    public static Date scheduleJob(JobDetail jobDetail, Trigger trigger) {
        try {
            return scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.scheduleJob 异常");
        }
    }


    public static Date scheduleJob(Trigger trigger) {
        try {
            return scheduler.scheduleJob(trigger);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.scheduleJob 异常");
        }
    }

    public static boolean unscheduleJob(TriggerKey triggerKey) {
        try {
            return scheduler.unscheduleJob(triggerKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.unscheduleJob 异常");
        }
    }


    public static Date rescheduleJob(TriggerKey triggerKey, Trigger newTrigger) {
        try {
            return scheduler.rescheduleJob(triggerKey,newTrigger);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.rescheduleJob 异常");
        }
    }


    public static void addJob(JobDetail jobDetail, boolean replace) {
        try {
            scheduler.addJob(jobDetail,replace);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.addJob 异常");
        }
    }


    public static void addJob(JobDetail jobDetail, boolean replace, boolean storeNonDurableWhileAwaitingScheduling) {
        try {
            scheduler.addJob(jobDetail,replace,storeNonDurableWhileAwaitingScheduling);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.addJob 异常");
        }
    }


    public static boolean deleteJob(JobKey jobKey) {
        try {
            return scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.deleteJob 异常");
        }
    }


    public static boolean deleteJobs(List<JobKey> jobKeys) {
        try {
            return scheduler.deleteJobs(jobKeys);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.deleteJobs 异常");
        }
    }


    public static void triggerJob(JobKey jobKey) {
        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.triggerJob 异常");
        }
    }


    public static void triggerJob(JobKey jobKey, JobDataMap data) {
        try {
            scheduler.triggerJob(jobKey,data);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.triggerJob 异常");
        }
    }


    public static void pauseJob(JobKey jobKey) {
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.pauseJob 异常");
        }
    }


    public static void pauseJobs(GroupMatcher<JobKey> matcher) {
        try {
            scheduler.pauseJobs(matcher);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.pauseJobs 异常");
        }
    }


    public static void pauseTrigger(TriggerKey triggerKey) {
        try {
            scheduler.pauseTrigger(triggerKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.pauseTrigger 异常");
        }
    }


    public static void pauseTriggers(GroupMatcher<TriggerKey> matcher) {
        try {
            scheduler.pauseTriggers(matcher);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.pauseTriggers 异常");
        }
    }


    public static void resumeJob(JobKey jobKey) {
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.resumeJob 异常");
        }
    }


    public static void resumeJobs(GroupMatcher<JobKey> matcher) {
        try {
            scheduler.resumeJobs(matcher);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.resumeJobs 异常");
        }
    }


    public static void resumeTrigger(TriggerKey triggerKey) {
        try {
            scheduler.resumeTrigger(triggerKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.resumeTrigger 异常");
        }
    }


    public static void resumeTriggers(GroupMatcher<TriggerKey> matcher) {
        try {
            scheduler.resumeTriggers(matcher);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.resumeTriggers 异常");
        }
    }


    public static void pauseAll() {
        try {
            scheduler.pauseAll();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.pauseAll 异常");
        }
    }


    public static void resumeAll() {
        try {
            scheduler.resumeAll();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.resumeAll 异常");
        }
    }


    public static List<String> getJobGroupNames() {
        try {
            return scheduler.getJobGroupNames();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getJobGroupNames 异常");
        }
    }


    public static Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) {
        try {
            return scheduler.getJobKeys(matcher);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getJobKeys 异常");
        }
    }


    public static List<? extends Trigger> getTriggersOfJob(JobKey jobKey) {
        try {
            return scheduler.getTriggersOfJob(jobKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getTriggersOfJob 异常");
        }
    }


    public static List<String> getTriggerGroupNames() {
        try {
            return scheduler.getTriggerGroupNames();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getTriggerGroupNames 异常");
        }
    }


    public static Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) {
        try {
            return scheduler.getTriggerKeys(matcher);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getTriggerKeys 异常");
        }
    }


    public static Set<String> getPausedTriggerGroups() {
        try {
            return scheduler.getPausedTriggerGroups();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getPausedTriggerGroups 异常");
        }
    }

    public static JobDetail getJobDetail(JobKey jobKey) {
        try {
            return scheduler.getJobDetail(jobKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getJobDetail 异常");
        }
    }


    public static Trigger getTrigger(TriggerKey triggerKey) {
        try {
            return scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getTrigger 异常");
        }
    }


    public static Trigger.TriggerState getTriggerState(TriggerKey triggerKey) {
        try {
            return scheduler.getTriggerState(triggerKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getTriggerState 异常");
        }
    }


    public static void resetTriggerFromErrorState(TriggerKey triggerKey) {
        try {
            scheduler.resetTriggerFromErrorState(triggerKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.resetTriggerFromErrorState 异常");
        }
    }


    public static void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers) {
        try {
            scheduler.addCalendar(calName,calendar,replace,updateTriggers);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.addCalendar 异常");
        }
    }


    public static boolean deleteCalendar(String calName) {
        try {
            return scheduler.deleteCalendar(calName);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.deleteCalendar 异常");
        }
    }


    public static Calendar getCalendar(String calName) {
        try {
            return scheduler.getCalendar(calName);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getCalendar 异常");
        }
    }


    public static List<String> getCalendarNames() {
        try {
            return scheduler.getCalendarNames();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.getCalendarNames 异常");
        }
    }


    public static boolean interrupt(JobKey jobKey) {
        try {
            return scheduler.interrupt(jobKey);
        } catch (UnableToInterruptJobException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.interrupt 异常");
        }
    }


    public static boolean interrupt(String fireInstanceId) {
        try {
            return scheduler.interrupt(fireInstanceId);
        } catch (UnableToInterruptJobException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.interrupt 异常");
        }
    }


    public static boolean checkExists(JobKey jobKey) {
        try {
            return scheduler.checkExists(jobKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.checkExists 异常");
        }
    }


    public static boolean checkExists(TriggerKey triggerKey) {
        try {
            return scheduler.checkExists(triggerKey);
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.checkExists 异常");
        }
    }

    public static void clear() {
        try {
            scheduler.clear();
        } catch (SchedulerException e) {
            throw BusinessException.newInstance(ResultCode.SCHEDULE_ERROR, e, "scheduler.clear 异常");
        }
    }
}
