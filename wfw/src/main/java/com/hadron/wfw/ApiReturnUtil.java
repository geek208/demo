package com.hadron.wfw;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname ApiReturnUtil.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public class ApiReturnUtil {
	//可以用 spring boot 的restTemplate 但是感觉 hutool 的 工具类已经封装好的，比较方便
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private WfwConfig config;

    /**
     * 授权 获取第三方的token 
     * @throws Exception
     */
    @PostMapping("/login")
    public String getHuiCalculatedOrderToken() throws Exception {
    //把第三方账号密码封装到map
        Map<String,Object> paramsMap=new HashMap<String,Object>();
        paramsMap.put("username", "123");
        paramsMap.put("password", "123");
        String tokenStr="";
//        // 直接丢地址 和账号密码获取第三方的token,顺便踹下错误，方便甩锅
//        try {
//            tokenStr= HttpUtil.post(config.toString() +"/auth2/token",paramsMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("第三方接口访问异常");
//        }
//      //用fastJson 解析一波  直接返回
//        JSONObject object=JSON.parseObject(tokenStr);
//        System.out.println(JSON.toJSONString(object));
//        String tokenObj = object.getString("token");
//        System.out.println(tokenObj);
//        JSONObject token = JSON.parseObject(tokenObj);
//        System.out.println("token-->"+token.getString("token"));
//        return token.getString("token");
		return tokenStr;
    }
    /**
     * 调用第三方接口，下单
     *    说明下： ApiReturnObject    ApiReturnUtil 是我们自己项目封装的返回 无需理会
     */
//    @PostMapping("/order")
//    public ApiReturnObject getgeneOrder(HuiCalculatedOrder huiCalculatedOrder) {
//    //把需要传的参数封装到map
//        Map<String,Object> paramsMap=new HashMap<String,Object>();
//        paramsMap.put("orderNum",huiCalculatedOrder.getOrderNum());
//        paramsMap.put("checkNum",huiCalculatedOrder.getCheckNum());
//        String post = null;
//        try {
//        	//因为第三方规定：header  需要传 token ， 所以用下面的链式构建
//             //post = HttpUtil.post(myProps.getHuiCalculatedOrderUrl() + "/gene/order/create", paramsMap);
//
//            //链式构建请求，用的是hutool 工具类
//            post = HttpRequest.post(myProps.getHuiCalculatedOrderUrl() + "/gene/order/create")
//                    .header("token", getHuiCalculatedOrderToken())  //value  是 上面获取的token
//                    .form(paramsMap).timeout(20000).execute().body();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return ApiReturnUtil.error("第三方接口错误",e.getMessage());
//        }
//        log.info(post);
//        JSONObject jsonbody= JSON.parseObject(post);   //使用了fastJson 工具类
//        if ("00".equals(jsonbody.getString("errorCode")) ){
//
//            return ApiReturnUtil.success("下单成功",post);
//        }else {
//            return ApiReturnUtil.error(jsonbody.getString("errorMessage"));
//        }
//
//    }

}
