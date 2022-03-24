package com.hadron.wfw.producer;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hadron.wfw.RedisService;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname Producer.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

@Component
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;
	@Autowired
	private RedisService redisService;

    private static Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() throws Exception {
        Message message = new Message();
        message.setId("KFK_"+System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        redisService.set(message.getId(), message.getMsg());
        System.err.print(gson.toJson(message));
        kafkaTemplate.send("test", gson.toJson(message));
    }

}
