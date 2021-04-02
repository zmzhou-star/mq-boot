package com.github.zmzhoustar;

import java.util.Observable;
import java.util.Observer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 观察者：读者粉丝
 * @title ReaderObserver
 * @author zmzhou
 * @version 1.0
 * date 2021/4/2 11:58
 */
@RequiredArgsConstructor
public class ReaderObserver implements Observer {

    @NonNull
    private final String name;

    private String article;

    @Override
    public void update(Observable o, Object arg) {
        // 更新文章
        updateArticle(o);
    }

    private void updateArticle(Observable o) {
        JavaStackObservable javaStackObservable = (JavaStackObservable) o;
        this.article = javaStackObservable.getArticle();
		System.out.printf("我是读者：%s，已更新文章：%s\n", this.name, this.article);
    }

}
