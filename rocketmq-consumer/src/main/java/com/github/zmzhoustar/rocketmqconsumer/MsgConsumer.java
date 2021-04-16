package com.github.zmzhoustar.rocketmqconsumer;

import java.nio.charset.StandardCharsets;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

import com.github.zmzhoustar.common.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * 消息消费者
 * MessageModel：集群模式；广播模式
 * ConsumeMode：顺序消费；无序消费
 * @author zmzhou
 * @version 1.0
 * date 2021/3/29 10:56
 * @title MsgConsumer
 */
@Slf4j
@Service
@RocketMQMessageListener(
		consumerGroup = Constants.CONSUMER_GROUP,
		selectorType = SelectorType.TAG, selectorExpression = "tag1",
		topic = Constants.TOPIC, consumeMode = ConsumeMode.CONCURRENTLY
)
public class MsgConsumer implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {
	@Override
	public void onMessage(MessageExt messageExt) {
		String msg = new String(messageExt.getBody(), StandardCharsets.UTF_8);
		log.info("MsgConsumer >>> {}, msgId = {}", msg, messageExt.getMsgId());
	}

	@Override
	public void prepareStart(DefaultMQPushConsumer mqPushConsumer) {
		log.info("DefaultMQPushConsumer：{}", mqPushConsumer);
	}
}
