package com.github.zmzhoustar;

/**
 * 观察者模式
 * @title App
 * @author zmzhou
 * @version 1.0
 * date 2021/4/2 11:56
 */
public class App {
	public static void main(String[] args) {
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
