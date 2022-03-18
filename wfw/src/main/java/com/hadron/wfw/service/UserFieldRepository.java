package com.hadron.wfw.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityRules;
import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwFormField;
import com.hadron.wfw.model.UserField;
import com.hadron.wfw.model.UserFieldGroup;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwFormFieldRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface UserFieldRepository extends JpaRepository<UserField, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	UserField findById(long id);
	
	@Query(value = "select * from t_user_field  WHERE org_id =?1",nativeQuery = true)
	List <UserField>   findByOrgId(String  orgId);
	
	// 查询人员所在 字段的值
	@Query(value = "select * from t_user_field  WHERE name =?1 and user_id =?2",nativeQuery = true)
	UserField  findByNameId(String  name ,String userId);
	
	@Query(value = "select * from t_user_field  WHERE name =?1 ",nativeQuery = true)
	UserField  findByName(String  name);
	
	
	//查询表单的字段
	@Query(value = "select * from t_user_field  WHERE flow_id =?1 AND userId is null",nativeQuery = true)
	List <UserField>   findByUserId(String  userId);
	
	//查询表单的字段
	@Query(value = "select * from t_user_field  WHERE  group_id =?1",nativeQuery = true)
	List <UserField>   findByGroupId(String  groupId);
	
	@Transactional
	@Modifying
	//@Query("update t_stock   set count = count-1 where id in ids",nativeQuery = true)
	@Query(value = "UPDATE t_user_field SET fieldvalue =?2   WHERE id =?1",nativeQuery = true)
	public void updateFieldValue(String fieldId,String fieldvalue);

	//绑定规则到活动节点上
	@Transactional
	@Modifying
	@Query(value = "UPDATE t_user_field SET activity_id =?2,rules =?3 WHERE id =?1",nativeQuery = true)
	public void updateFieldActivity(String fieldId,String activityId,String rules);
	
	void save(WfwActivityRules e);

}
