package com.lenovo.task_manager.dao;

import com.lenovo.task_manager.entity.QuartzJobPlanConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : zhanghh
 * @businessDesc :
 * @project : task-manager
 * @date : 2019/4/19 10:56
 */
@Repository
public interface QuartzJobPlanConfigDao extends JpaRepository<QuartzJobPlanConfig,String> {
}
