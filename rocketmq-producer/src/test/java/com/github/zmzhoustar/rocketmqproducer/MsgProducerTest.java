package com.github.zmzhoustar.rocketmqproducer;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * 消息生产者测试
 * @title MsgProducerTest
 * @author zmzhou
 * @version 1.0
 * date 2021/3/29 11:01
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MsgProducerTest {
	@Autowired
	private MsgProducer msgProducer;

	@Test
	void sendUserMsg() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			UserVo msg = UserVo.builder()
				.id(i + 1).address("广州市白云区")
				.age(20 + i).name("zmzhou-star" + i)
				.build();
			msgProducer.sendUserMsg(msg);
			TimeUnit.MILLISECONDS.sleep(10);
		}
	}
}
