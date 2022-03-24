package com.hadron.wfw.service;


import org.springframework.data.jpa.repository.JpaRepository;

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
public interface OrgRepository extends JpaRepository<WfwOrg, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	WfwOrg findById(long id);

	void save(WfwOrgUser au);
}
