package com.hadron.wfw.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname UserRepository.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Repository
public interface UserJobLevelRepository extends JpaRepository<UserJobLevel, Integer> {
	UserJobLevel findById(int id);

}
