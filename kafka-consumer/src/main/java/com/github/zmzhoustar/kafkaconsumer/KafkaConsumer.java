package com.github.zmzhoustar.kafkaconsumer;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 消息接收类
 *
 * @author zmzhou
 * @version 1.0
 * @title KafkaConsumer
 * @date 2021/4/1 22:33
 */
@Slf4j
@Component
public class KafkaConsumer {

	@KafkaListener(topics = {"springboot-kafka"})
	public void listen(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			log.info("---- record = {}", record);
			log.info("---- message = {}", message);
		}

	}
}
