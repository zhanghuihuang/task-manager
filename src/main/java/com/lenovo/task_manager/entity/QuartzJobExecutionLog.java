package com.lenovo.task_manager.entity;

import com.lenovo.task_manager.enums.JobTaskStatusEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/19 9:15
 */
@Entity
@Table(name="t_quartz_job_execution_log")
public class QuartzJobExecutionLog implements Serializable {
    @Id
    @GenericGenerator(name="uuid",strategy="uuid")
    @GeneratedValue(generator="uuid")
    private String id;
    @Column(name="job_plan_id")
    private String jobPlanId;
    @Column(name="start_time")
    private Date startTime;
    @Column(name="end_time")
    private Date endTime;
    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    private JobTaskStatusEnum status=JobTaskStatusEnum.RUNNING;
    @Column(name="result_msg")
    private String resultMsg;
}
