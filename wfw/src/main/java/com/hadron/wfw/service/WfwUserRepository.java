package com.hadron.wfw.service;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hadron.wfw.model.WfwActivityUser;
import com.hadron.wfw.model.WfwUser;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwUserRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public interface WfwUserRepository extends JpaRepository<WfwUser, Long> {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
    WfwUser findById(long id);
    
    void save(WfwActivityUser au);
    
    //找到处理人
  	 @Query(value = "select  DISTINCT u.* FROM t_wfw_role ,t_wfw_user AS u ,t_wfw_role_user WHERE u.id = t_wfw_role_user.user_id AND t_wfw_role_user.role_id = t_wfw_role.id AND t_wfw_role.id  = ?1",nativeQuery = true )
  	 List<Map<String,String>>    findByRole(String  roleId);
    
  	 
  	//找到处理人
  	 @Query(value = "select  DISTINCT u.*  FROM t_wfw_org,t_wfw_user AS u ,t_wfw_org_user WHERE u.id = t_wfw_org_user.user_id AND t_wfw_org_user.org_id = t_wfw_org.id AND t_wfw_org.id = ?1",nativeQuery = true )
  	 List<Map<String,String>>    findByOrg(String  orgId);
  	 
    //SELECT
//    u.*
//    FROM
//    t_wfw_role ,
//    t_wfw_user AS u ,
//    t_wfw_role_user
//    WHERE
//    u.id = t_wfw_role_user.user_id AND
//    t_wfw_role_user.role_id = t_wfw_role.id AND
//    t_wfw_role.id = 24480


}
