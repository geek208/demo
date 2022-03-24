package com.hadron.app;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname WfwOrg.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 * https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html
 *  第一步：请求CODE
 *  第三方使用网站应用授权登录前请注意已获取相应网页授权作用域（scope=snsapi_login），则可以通过在PC端打开以下链接：
 *  https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE
 *  #wechat_redirect 若提示“该链接无法访问”，请检查参数是否填写错误，如redirect_uri的域名与审核时填写的授权域名不一致或scope不为snsapi_login。
 *
 * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
 */

@Entity
@Table(name = "t_platform_app")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class PlatformApp {

    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String cnName;
    private String clientId;
    private String appId;
    private String clientSecret;
    private String scope;
    private String redirectUri;
    private String response_type;
    // 授权state
    private String state;
    //是否禁用
    private String status;
}
