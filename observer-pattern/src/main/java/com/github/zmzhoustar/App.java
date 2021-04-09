package com.github.zmzhoustar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.JDK观察者模式
 * 2.spring的事件监听有三个部分组成，事件（ApplicationEvent)、监听器(ApplicationListener)和事件发布操作。
 * @title App
 * @author zmzhou
 * @version 1.0
 * date 2021/4/2 11:56
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("观察者模式!");
		// 创建一个观察目标
		JavaStackObservable javaStackObservable = new JavaStackObservable();

		// 添加观察者
		javaStackObservable.addObserver(new ReaderObserver("小明"));
		javaStackObservable.addObserver(new ReaderObserver("小张"));
		javaStackObservable.addObserver(new ReaderObserver("小爱"));

		// 发表文章
		javaStackObservable.publish("什么是观察者模式？");
	}
}
