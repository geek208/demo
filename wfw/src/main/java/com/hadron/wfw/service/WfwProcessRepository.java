package com.hadron.wfw.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwFormField;
import com.hadron.wfw.model.WfwProcess;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwProcessRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface WfwProcessRepository extends JpaRepository<WfwProcess, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	WfwProcess findById(long id);
	
	@Transactional
	@Modifying
	//@Query("update t_stock   set count = count-1 where id in ids",nativeQuery = true)
	@Query(value = "UPDATE t_wfw_process SET status =?2   WHERE id =?1",nativeQuery = true)
	public void updateCurrent(String pid,String currentId);
	
	@Transactional
	@Modifying
	//@Query("update t_stock   set count = count-1 where id in ids",nativeQuery = true)
	@Query(value = "UPDATE t_wfw_process SET status =?2   WHERE id =?1",nativeQuery = true)
	public void updateNext(String pid,String nextId);
	
	//查询表单的字段
	@Query(value = "select * from t_wfw_process  WHERE flow_id =?1",nativeQuery = true)
	List <WfwProcess>   findProcessByflowId(String  flowId);

}
