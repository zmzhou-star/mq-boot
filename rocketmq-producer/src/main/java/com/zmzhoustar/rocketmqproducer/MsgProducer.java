package com.zmzhoustar.rocketmqproducer;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 消息生产者
 * @title MsgProducer
 * @author zmzhou
 * @version 1.0
 * date 2021/3/29 10:53
 */
@Slf4j
@Component
public class MsgProducer {

    @Autowired
    private RocketMQTemplate mqTemplate;

    public void sendUserMsg(UserVo userVo){
        log.info("发送同步消息：{}", userVo);
        SendResult sendResult = mqTemplate.syncSend(Constants.TOPIC, JSON.toJSONString(userVo));
        log.info("发送同步消息成功：{}", sendResult);
    }
}
