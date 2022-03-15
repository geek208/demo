package com.hadron.wfw;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname CorsConfig.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */


@Configuration
public class CorsConfig extends  WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        //添加映射路径
        registry.addMapping("/**")
//                //是否发送Cookie
                .allowCredentials(true)
//                //设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")    
//                //.allowedOrigins("*")
                .allowedOrigins("*");
//                //放行哪些请求方式
//                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
//                //.allowedMethods("*") //或者放行全部
//                //放行哪些原始请求头部信息
//                .allowedHeaders("*")
//                //暴露哪些原始请求头部信息
 //               .exposedHeaders("*");
    }
}