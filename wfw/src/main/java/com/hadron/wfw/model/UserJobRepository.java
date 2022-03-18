package com.hadron.wfw.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hadron.wfw.model.User;
import com.hadron.wfw.model.UserField;
import com.hadron.wfw.model.WfwTask;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname UserRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Repository
public interface UserJobRepository extends JpaRepository<UserJob, Integer> {
	
	@Query(value = "select * from t_wfw_user  WHERE role_id =?1",nativeQuery = true)
	List <UserJob>   findUserByRole(String  userId);
	UserJob findById(int id);
	
}
