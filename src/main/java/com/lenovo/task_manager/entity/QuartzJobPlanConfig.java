package com.lenovo.task_manager.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/19 9:03
 */
@Entity
@Table(name="t_quartz_job_plan_config")
@Data
public class QuartzJobPlanConfig implements Serializable {

    @Id
    @GenericGenerator(name="uuid",strategy="uuid")
    @GeneratedValue(generator="uuid")
    private String id;               //主键
    @Column(name="name")
    private String name;             //任务计划名称
    @Column(name="class_name")
    private String className;        //任务类名
    @Column(name="description")
    private String description;      //计划说明
    @Column(name="status")
    private boolean status=false;    //启动状态
    @Column(name="auto_start")
    private boolean autoStart=false; //1系统自动启动，0否
    @Column(name="cron_expression")
    private String cronExpression;   //cron表达式
    @Column(name="last_run_time")
    private Date lastRunTime;        //上次执行时间
    @Column(name="next_run_time")
    private Date nextRunTime;        //下次执行时间
    @Column(name="create_at")
    private Date createAt;           //创建时间
    @Column(name="create_by")
    private String createBy;         //创建者
    @Column(name="update_at")
    private Date updateAt;           //更新时间
    @Column(name="update_by")
    private String updateBy;         //更新者

}
