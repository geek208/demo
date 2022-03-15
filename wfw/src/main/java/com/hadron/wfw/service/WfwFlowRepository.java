package com.hadron.wfw.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwFlow;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwFlowRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface WfwFlowRepository extends JpaRepository<WfwFlow, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	WfwFlow findById(long id);
	
	@Transactional
	@Modifying
	//@Query("update t_stock   set count = count-1 where id in ids",nativeQuery = true)
	@Query(value = "UPDATE t_easy_pay SET status =?2   WHERE order_sn =?1",nativeQuery = true)
	public void updatePayStatus(String orderSn,String status);

}
