package com.hadron.wfw.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.Cookie;
import javax.xml.validation.Validator;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.hadron.wfw.Utils;
import com.hadron.wfw.cache.UserCache;
import com.hadron.wfw.model.SysUser;
import com.hadron.wfw.model.UserVO;

import lombok.extern.slf4j.Slf4j;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname UserService.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Slf4j
@Service
public class UserService  implements UserDetailsService{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserCache userCache;

    public static final String COOKIE_NAME = "auth";
    
    public SysUser login(UserVO user) {
    	System.err.println("用戶輸入用戶密碼  appId =[" + user.getEmail() + "] password=["
   				+ user.getPassword() + "] role ==[" + user.getRole()+ "]");
    	Example<SysUser> userExample = Example.of(SysUser.builder().email(StringUtils.trim(user.getEmail()))
                .password(StringUtils.trim(user.getPassword())).build());
        SysUser dbUser = userRepository.findOne(userExample).orElse(null);
        return dbUser;
    }


   
    public String encodePassword(String pw) {
        return DigestUtils.md5Hex(pw);
    }



	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息

//        Example<User> userExample = Example.of(User.builder().email(StringUtils.trim(user.getEmail()))
//                .password(StringUtils.trim(user.getPassword())).build());
//        User dbUser = userRepository.findOne(userExample).orElse(null);
//        
        SysUser user = userRepository.findUserByName(arg0);
        
        System.err.println("初始化配置到内存 appId =[" + user.getEmail() + "] password=["
				+ user.getPassword() + "] role ==[" + user.getRole()+ "]");
        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        
//        UserVO userVO = user.toVO(UserVO.class);
//        String cKey = Utils.getCharAndNum(10);
//        Cookie cookie = new Cookie(COOKIE_NAME, cKey);
//        // cookie.setDomain(domain);
//        //12个小时
//        cookie.setMaxAge(60 * 60 * 12);
//        cookie.setPath("/");
//        // xss
//     //   cookie.setHttpOnly(true);
//      //  response.addHeader("Access-Control-Allow-Credentials", "true");
//        response.addCookie(cookie);
//        System.out.println(response.toString());
        
//        userCache.setCache(cKey, userVO);
        
        authorities.add(new SimpleGrantedAuthority(user.getRole()));

        // 添加权限
//        List<SysUserRole> userRoles = sysUserRoleMapper.listByUserId(user.getId());
//        for (SysUserRole userRole : userRoles) {
//            SysRole role = sysRoleMapper.selectById(userRole.getRoleId());
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        
        String password = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword().trim());
        
        System.err.println(" password before =[" + user.getPassword() + "] after password=["
				+  password + "] role ==[" + user.getRole()+ "]");
        // 判断用户是否存在
        
       // return  (UserDetails) new User(user.getEmail(), "{noop}"+user.getPassword().trim(), authorities);
        return  (UserDetails) new User(user.getEmail(), user.getPassword().trim(), authorities);
        
        // 返回UserDetails实现类
        //return  (UserDetails) new User(user.getEmail(),   PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()), authorities);
	}
}
