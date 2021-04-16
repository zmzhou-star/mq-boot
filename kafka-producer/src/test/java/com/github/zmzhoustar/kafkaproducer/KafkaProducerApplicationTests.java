package com.github.zmzhoustar.kafkaproducer;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.zmzhoustar.common.Message;

@SpringBootTest
class KafkaProducerApplicationTests {
	@Autowired
	private KafkaProducer kafkaProducer;
	@Test
	void contextLoads() {
		for (long i = 0; i < 100; i++) {
			Message msg = Message.builder()
				.id(i + 1)
				.msg(UUID.randomUUID().toString())
				.timestamp(new Date())
				.build();
			kafkaProducer.send(msg);
		}
	}

}
