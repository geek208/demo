package com.hadron.wfw.api;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hadron.wfw.Result;
import com.hadron.wfw.ResultData;
import com.hadron.wfw.Utils;
import com.hadron.wfw.cache.UserCache;
import com.hadron.wfw.model.User;
import com.hadron.wfw.model.UserVO;
import com.hadron.wfw.model.WfwUser;
import com.hadron.wfw.service.UserRepository;
import com.hadron.wfw.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserCache userCache;

    public static final String COOKIE_NAME = "auth";
    
    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody UserVO user, HttpServletRequest request, HttpServletResponse response) {
    	
    	log.debug("pre md5Hex{} after {}"+user.getPassword(),DigestUtils.md5Hex(StringUtils.trim(user.getPassword())));
        user.setPassword(DigestUtils.md5Hex(StringUtils.trim(user.getPassword())));
        
        User loginUser = userService.login(user);
        UserVO userVO = loginUser.toVO(UserVO.class);
        String cKey = Utils.getCharAndNum(10);
        Cookie cookie = new Cookie(COOKIE_NAME, cKey);
        // cookie.setDomain(domain);
        //12个小时
        cookie.setMaxAge(60 * 60 * 12);
        cookie.setPath("/");
        // xss
     //   cookie.setHttpOnly(true);
      //  response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addCookie(cookie);
        System.out.println(response.toString());
        
        userCache.setCache(cKey, userVO);
    	
//        ResultData data =new ResultData();
//        data.setCode(20000);
//        data.setSuccess(true);
//        data.setMessage("成功");
//        
//        data.setData("admin-token");
//        return data;

        return Result.buildSuccess(userVO, null);
    }


    @GetMapping("/logout")
    public Result logout(@CookieValue(value = COOKIE_NAME, defaultValue = "") String auth, HttpServletResponse response) {
        if (auth != null) {
            Cookie cookie = new Cookie(COOKIE_NAME, "");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        userCache.rmCache(auth);
        return Result.doSuccess();
    }
    
    /**
     * cache
     *
     * @param auth
     * @return
     */
    // @PreAuth("vip")
    @GetMapping("/info")
    public Result getUserInfo(@CookieValue(value = COOKIE_NAME, defaultValue = "") String auth) {
        if (StringUtils.isBlank(auth)) return Result.builder().code(403).message("无权限").build();
        UserVO cache = userCache.getCache(auth);
        if (cache == null) return Result.builder().code(403).message("认证已经过期，请重新登录").build();
        Map<String, Object> userMap = Maps.newHashMap();
        userMap.put("roles", Lists.newArrayList(cache.getRole()));
        userMap.put("name", cache.getEmail());
        //userMap.put("avatar", "https://apic.douyucdn.cn/upload/avanew/face/201705/15/17/109dae304969a8dc9dfd318c34cb71e9_middle.jpg");
        return Result.builder().code(Result.CODE_SUCCESS).obj(userMap).build();
    }
    
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     * @throws Exception 
     */
    @RequestMapping("/createUser")
	@ResponseBody
    public ResultData createUser(User user) throws Exception {
    	
    	
    	log.debug("pre md5Hex{} after {}"+user.getPassword(),DigestUtils.md5Hex(StringUtils.trim(user.getPassword())));
    	
    	user.setPassword(DigestUtils.md5Hex(StringUtils.trim(user.getPassword())));
    	userRepository.save(user);
       // producer.send();
        
   	    // 声明httpPost请求
        //HttpPost httpPost = new HttpPost("http://www.baidu.com");
		//httpClient.execute(httpPost);
		//httpAPIService.doGet("http://www.baidu.com");
		//httpAPIService.doGet("http://10.0.0.79:30093/apm/add?id="+user.getId()+"&userName="+user.getUserName()+"&password=1&age=1");
		//httpAPIService.doGet("http://10.0.0.79:30095/mall/addOrder?id="+user.getId()+"&name="+user.getUserName()+"&money=2&fee=2");
        //return gson.toJson("200");
    	ResultData data = new ResultData();
		data.setCode(200);
		data.setSuccess(true);
		data.setMessage("成功");
		data.setData(user);
		return data;
     
    }
}
