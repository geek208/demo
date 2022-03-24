package com.hadron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hadron.wfw.api.UserController;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwApplication.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
//@EnableOAuth2Sso
@SpringBootApplication
//@RestController
@EnableAuthorizationServer
@Slf4j
public class WfwApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfwApplication.class, args);
	}
	
//	   // sso测试接口
//    @GetMapping("/user")
//    public Authentication getUser(Authentication authentication) {
//        log.info("auth : {}", authentication);
//        System.err.println("auth: user {}"+ authentication.getDetails().toString());
//        return authentication;
//
//    }
}
