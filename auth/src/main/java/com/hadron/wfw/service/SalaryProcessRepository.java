package com.hadron.wfw.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hadron.wfw.model.SalaryProcess;
import com.hadron.wfw.model.SalaryTemplate;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname OrgRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface SalaryProcessRepository extends JpaRepository<SalaryProcess, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	SalaryProcess findById(long id);

	//void save(WfwOrgUser au);
}
