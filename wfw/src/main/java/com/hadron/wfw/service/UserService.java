package com.hadron.wfw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.validation.Validator;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.hadron.wfw.model.User;
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
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    public User login(UserVO user) {



        Example<User> userExample = Example.of(User.builder().email(StringUtils.trim(user.getEmail()))
                .password(StringUtils.trim(user.getPassword())).build());
        User dbUser = userRepository.findOne(userExample).orElse(null);
        return dbUser;
    }


   
    public String encodePassword(String pw) {
        return DigestUtils.md5Hex(pw);
    }
}
