package com.github.zmzhoustar;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * pulsar配置
 * @title PulsarConfig
 * @author zmzhou
 * @version 1.0
 * @since 2021/5/6 16:18
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "pulsar")
public class PulsarConfig {
	/**
	 * pulsar服务端地址
	 */
	private String url;
	/**
	 * topic
	 */
	private String topic;
	/**
	 * 消费者组
	 */
	private String subscription;
}
