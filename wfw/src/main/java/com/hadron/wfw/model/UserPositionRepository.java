package com.hadron.wfw.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hadron.wfw.model.User;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname UserRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Repository
public interface UserPositionRepository extends JpaRepository<UserPosition, Integer> {
	
	@Query(value = "select * from t_wfw_user  WHERE role_id =?1",nativeQuery = true)
	List <UserPosition>   findUserByRole(String  userId);
	

	
	UserPosition findById(int id);
	
}
