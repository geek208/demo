package com.hadron.app;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hadron.wfw.model.SysUser;
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
public interface PlatformAppRepository extends JpaRepository<PlatformApp, Integer> {
	
	@Query(value = "select * from t_platform_app  WHERE role_id =?1",nativeQuery = true)
	List <PlatformApp>   findUserByRole(String  userId);
	
	
	PlatformApp findById(int id);
	
	void save(OrderApp orderApp);
	
	void save(PublishApp publishApp);
	
}
