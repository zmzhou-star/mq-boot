package com.github.zmzhoustar;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.SubscriptionInitialPosition;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	/**
	 * 使用@PostConstruct注解用于在依赖关系注入完成之后需要执行的方法上，以执行任何初始化
	 */
	@PostConstruct
	public void initPulsar() {
		try {
			//构造Pulsar client
			client = PulsarClient.builder()
				.serviceUrl(config.getUrl())
				.build();
			//创建consumer
			consumer = client.newConsumer()
				.topic(config.getTopic().split(","))
				.subscriptionName(config.getSubscription())
				//指定消费模式，包含：Exclusive，Failover，Shared，Key_Shared。默认Exclusive模式
				.subscriptionType(SubscriptionType.Shared)
				//指定从哪里开始消费还有Latest，valueof可选，默认Latest
				.subscriptionInitialPosition(SubscriptionInitialPosition.Latest)
				//指定消费失败后延迟多久broker重新发送消息给consumer，默认60s
				.negativeAckRedeliveryDelay(60, TimeUnit.SECONDS)
				.autoUpdatePartitions(true)
				.subscribe();

			// 开始消费
			receive();
		} catch (Exception e) {
			log.error("Pulsar初始化异常：", e);
		}
	}

	public void receive() {
		Executors.newFixedThreadPool(1).execute(() -> {
			try {
				while (true) {
					CompletableFuture<Message> asyncMessage = consumer.receiveAsync();
					log.info("receive message: {}", new String(asyncMessage.get().getData()));
				}
			} catch (Exception e) {
				log.error("Pulsar消费异常：", e);
			}
		});
	}
}
