package com.hadron.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hadron.app.PlatformAppRepository;
import com.hadron.wfw.service.UserRepository;
import com.hadron.wfw.service.UserService;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/5/20 17:41
 * @describtion: WebSecurityConfigurer
 */
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
    PlatformAppRepository platformAppRepository;

	
//	@Autowired
//    UserService userService;
	
    private final UserService userService;

    public WebSecurityConfigurer(UserService userService) {
        this.userService = userService;
    }

    // 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	//userRepository
    	//userService.login(user)
        //    	
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    	
		//        auth.inMemoryAuthentication()
		//                .withUser("admin")
		//                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                antMatchers("/oauth/**")
                .permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
        .and().csrf().disable();
    }
}
