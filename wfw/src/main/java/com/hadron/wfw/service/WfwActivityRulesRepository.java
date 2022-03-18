package com.hadron.wfw.service;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityRules;
import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.UserField;
import com.hadron.wfw.model.WfwLink;
import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwActivityRulesRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface WfwActivityRulesRepository extends JpaRepository<WfwActivityRules, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	WfwActivity findById(long id);
	
	@Transactional
	@Modifying
	//@Query("update t_stock   set count = count-1 where id in ids",nativeQuery = true)
	@Query(value = "UPDATE t_easy_pay SET status =?2   WHERE order_sn =?1",nativeQuery = true)
	public void updatePayStatus(String orderSn,String status);
	
	//void save(WfwActivityRules war);
	
	void save(WfwLink link);
	
	//找到处理人,暂时只支持一套规则
	@Query(value = "SELECT r.* FROM t_wfw_activity_rules AS r , t_wfw_activity AS a , t_wfw_form_field AS f WHERE r.activity_id = a.id AND r.field_id = f.id AND a.id  =?1",nativeQuery = true )
 	WfwActivityRules  findFieldRulesByActivityId(String  ativityId);


}
