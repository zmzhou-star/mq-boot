package com.github.zmzhoustar.kafkaproducer;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * kafka消息生产者
 *
 * @author zmzhou
 * @version 1.0
 * @title KafkaProducerApplication
 * @date 2021/4/1 22:38
 */
@Slf4j
@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(KafkaProducerApplication.class, args);
		KafkaProducer kafkaProducer = context.getBean(KafkaProducer.class);
		for (long i = 0; i < 10; i++) {
			Message msg = Message.builder()
				.id(i + 1)
				.msg(UUID.randomUUID().toString())
				.timestamp(new Date())
				.build();
			kafkaProducer.send(msg);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				log.error("error:", e);
			}
		}
	}

}
