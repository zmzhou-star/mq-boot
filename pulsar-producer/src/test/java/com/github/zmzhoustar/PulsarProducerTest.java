package com.github.zmzhoustar;

import java.util.concurrent.TimeUnit;

import org.apache.pulsar.client.api.MessageId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.zmzhoustar.common.UserVo;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PulsarProducerTest {
	@Autowired
	private PulsarProducer producer;

	@Test
	void sendMsg() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			UserVo msg = UserVo.builder()
				.id(i + 1).address("广州市白云区")
				.age(20 + i).name("zmzhou-star" + i)
				.build();
			final MessageId messageId = producer.sendMsg(i + "", msg.toString());
			Assertions.assertNotNull(messageId);
			TimeUnit.MILLISECONDS.sleep(100);
		}
	}
}
