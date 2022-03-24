package com.hadron.wfw.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hadron.wfw.model.SalaryTemplate;
import com.hadron.wfw.model.SalaryUser;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname OrgRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface SalaryTemplateRepository extends JpaRepository<SalaryTemplate, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	SalaryTemplate findById(long id);

	void save(SalaryUser au);
}
