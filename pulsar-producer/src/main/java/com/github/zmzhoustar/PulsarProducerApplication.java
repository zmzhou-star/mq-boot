package com.github.zmzhoustar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Pulsar消息生产者
 * @title PulsarProducerApplication
 * @author zmzhou
 * @version 1.0
 * @since 2021/5/6 15:55
 */
@SpringBootApplication
public class PulsarProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulsarProducerApplication.class, args);
	}

}
