package com.hadron.wfw;
/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname HttpResult.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public class HttpResult {

    // 响应码
    private Integer code;

    // 响应体
    private String body;

    public HttpResult() {
        super();
    }

    public HttpResult(Integer code, String body) {
        super();
        this.code = code;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}