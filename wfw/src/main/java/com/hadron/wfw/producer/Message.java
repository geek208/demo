package com.hadron.wfw.producer;

import java.util.Date;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname Message.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public class Message {

    private String id;

    private String msg;

    private Date sendTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
