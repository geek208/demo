package com.hadron.wfw.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname Consumer.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Component
public class Consumer {

    @KafkaListener(topics = {"pay"})
    public void listen(ConsumerRecord<?, ?> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            System.err.println("pay---->"+record);
            System.err.println("pay---->"+message);

        }

    }
}
