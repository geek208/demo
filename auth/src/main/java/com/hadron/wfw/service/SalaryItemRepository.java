package com.hadron.wfw.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hadron.wfw.model.SalaryItem;
import com.hadron.wfw.model.WfwActivity;
import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwOrg;
import com.hadron.wfw.model.WfwOrgUser;
import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname OrgRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface SalaryItemRepository extends JpaRepository<SalaryItem, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	SalaryItem findById(long id);
	
	//找到处理人
	@Query(value = "select  * from t_salary_item a  WHERE a.id =?1",nativeQuery = true )
	SalaryItem  findByActivityId(String  atctivityId);
	
	@Query(value = "select  * from t_salary_item a WHERE a.temp_id =?1 and p_id is null",nativeQuery = true )
 	List <SalaryItem>  findByTempId(String  tempId);
}
