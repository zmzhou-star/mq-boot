package com.zmzhoustar.rocketmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消息消费者
 * @title RocketmqConsumerApplication
 * @author zmzhou
 * @version 1.0
 * @date 2021/3/29 20:45
 */
@SpringBootApplication
public class RocketmqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketmqConsumerApplication.class, args);
	}

}
