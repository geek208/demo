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
import com.hadron.wfw.model.WfwFormField;
import com.hadron.wfw.model.WfwLink;
import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwActivityRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface WfwActivityRepository extends JpaRepository<WfwActivity, Long> {
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
	
	
	  /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	//WfwFormField findById(long id);
	
	
	//找到处理人
	@Query(value = "select  DISTINCT u.* from t_wfw_activity a, t_wfw_activity_user AS au ,t_wfw_user AS u  WHERE au.activity_id = a.id AND au.user_id = u.id AND a.id =?1",nativeQuery = true )
	 List<Map<String,String>>    findByUActivityId(String  atctivityId);
	
	//找到处理人
	 @Query(value = "select  DISTINCT u.* from t_wfw_activity a, t_wfw_activity_user AS au ,t_wfw_user AS u  WHERE au.activity_id = a.id AND au.user_id = u.id AND a.id =?1",nativeQuery = true )
     List<WfwUser>    findByUserActivityId(String  atctivityId);
	
	//找到处理人
	@Query(value = "select  * from t_wfw_activity a  WHERE a.id =?1",nativeQuery = true )
	WfwActivity  findByActivityId(String  atctivityId);

	//找到处理人
	@Query(value = "select  * from t_wfw_activity a WHERE a.flow_id =?1",nativeQuery = true )
 	List <WfwActivity>  findByflowId(String  flowId);
	
	//找到规则的审批节点
	@Query(value = "select  * from t_wfw_activity a WHERE a.field_id =?1",nativeQuery = true )
	WfwActivity  findByfielId(String  fielId);
	
	//找到处理人
	@Query(value = "select  * from t_wfw_activity a WHERE a.flow_id =?1 and a.next_activity =0 ",nativeQuery = true )
	WfwActivity  findEndByflowId(String  flowId);
	
	
	//找到后续节点
	@Query(value = "select  DISTINCT N.* FROM t_wfw_activity AS p ,t_wfw_link ,t_wfw_activity AS n WHERE p.id = t_wfw_link.pre_id AND n.id =t_wfw_link.next_id AND  P.id= ?1",nativeQuery = true )
    List<Map<String,String>>    findNext(String  atctivityId);
    
	
	//保存规则
	void save(WfwActivityUser au);
	
	//SELECT r.* FROM t_wfw_activity_rules AS r ,t_wfw_activity AS a ,t_wfw_form_field AS f WHERE r.activity_id = a.id AND r.field_id = f.id AND a.id = 688
	//void save(WfwActivityRules aur);
	
	//找到规则 ，一个字段 目前只支持一条规则
	@Query(value = "SELECT DISTINCT r.* FROM t_wfw_activity_rules AS r ,t_wfw_activity AS a ,t_wfw_form_field AS f WHERE r.activity_id = a.id AND r.field_id = f.id AND a.id = ?1 ",nativeQuery = true )
	List<Map<String,String>>  findRulesById(String  activityId);
	
	
	void save(WfwLink link);
	

}
