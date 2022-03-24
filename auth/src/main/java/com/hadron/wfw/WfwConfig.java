package com.hadron.wfw;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwConfig.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

@Component  
@Data  //简写get  set 的注解
@ConfigurationProperties(prefix="bizmate") //接收application.yml中的myProps下面的属性
public class WfwConfig {
 
	public String bank;
	public String order;

}
