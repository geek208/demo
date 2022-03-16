package com.hadron.wfw.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwRole;
import com.hadron.wfw.model.WfwRoleUser;
import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname RoleRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface RoleRepository extends JpaRepository<WfwRole, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
	WfwRole findById(long id);
	
    void save(WfwRoleUser au);
}
