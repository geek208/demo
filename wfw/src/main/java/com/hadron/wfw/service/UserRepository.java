package com.hadron.wfw.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hadron.wfw.model.SysUser;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname UserRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer> {
	
	@Query(value = "select * from t_wfw_user  WHERE role_id =?1",nativeQuery = true)
	List <SysUser>   findUserByRole(String  userId);
	
	@Query(value = "select * from t_wfw_user  WHERE position_id =?1",nativeQuery = true)
	List <SysUser>   findUserByPosition(String  userId);
	
	@Query(value = "select * from t_wfw_user  WHERE job_id =?1",nativeQuery = true)
	List <SysUser>   findUserByJob(String  userId);
	
	@Query(value = "select * from t_wfw_user  WHERE org_id =?1",nativeQuery = true)
	List <SysUser>   findUserByOrg(String  userId);
	
	@Query(value = "select * from t_wfw_user  WHERE email =?1",nativeQuery = true)
	SysUser   findUserByName(String  email);
	
	SysUser findById(int id);
	
}
