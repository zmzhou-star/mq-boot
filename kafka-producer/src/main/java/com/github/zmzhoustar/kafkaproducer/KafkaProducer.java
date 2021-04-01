package com.github.zmzhoustar.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 发送消息
 * @title KafkaProducer
 * @author zmzhou
 * @version 1.0
 * @date 2021/4/1 21:58
 */
@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息
     * @param message Message
     * @author zmzhou
     * @date 2021/4/1 22:08
     */
    public void send(Message message) {
        String msg = JSON.toJSONString(message);
        log.info("+++ Kafka Producer message = {}", msg);
        kafkaTemplate.send("springboot-kafka", msg);
    }
}
