package com.github.zmzhoustar;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.SubscriptionInitialPosition;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.zmzhoustar.common.Constants;
import com.github.zmzhoustar.common.ThreadPoolUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费者
 *
 * @author zmzhou
 * @version 1.0
 * @title PulsarConsumer
 * @since 2021/5/6 16:55
 */
@Slf4j
@Component
public class PulsarConsumer {
	@Autowired
	private PulsarConfig config;
	private PulsarClient client = null;
	private Consumer consumer = null;

	@PostConstruct
	public void initPulsarConsumer() {
		try {
			//构造Pulsar client
			client = PulsarClient.builder()
				.serviceUrl(config.getUrl())
				.build();
			//创建consumer
			consumer = client.newConsumer()
				.topic(config.getTopic().split(Constants.COMMA))
				.subscriptionName(config.getSubscription())
				//指定消费模式，包含：Exclusive，Failover，Shared，Key_Shared。默认Exclusive模式
				.subscriptionType(SubscriptionType.Exclusive)
				//指定从哪里开始消费还有Latest，valueof可选，默认Latest
				.subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
				//指定消费失败后延迟多久broker重新发送消息给consumer，默认60s
				.negativeAckRedeliveryDelay(60, TimeUnit.SECONDS)
				.autoUpdatePartitions(true)
				.subscribe();
			// 开始消费
			receive();
		} catch (Exception e) {
			log.error("Pulsar Consumer初始化异常：", e);
		}
	}

	public void receive() {
		ThreadPoolUtils.execute(() -> {
			while (true) {
				CompletableFuture<Message> asyncMessage = consumer.receiveAsync();
				try {
					log.info("receive message: {}", new String(asyncMessage.get().getData()));
				} catch (InterruptedException | ExecutionException e) {
					log.error("Pulsar消费异常：", e);
				}
			}
		});
	}
}
