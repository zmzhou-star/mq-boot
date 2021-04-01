package com.github.zmzhoustar.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * kafka消息队列消费者
 * @title KafkaConsumerApplication
 * @author zmzhou
 * @version 1.0
 * @date 2021/4/1 22:24
 */
@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
