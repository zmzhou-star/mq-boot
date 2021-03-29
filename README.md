# rocketmq-boot
rocketmq + spring boot消息队列示例

## rocketmq安装
[http://rocketmq.apache.org/docs/quick-start/](http://rocketmq.apache.org/docs/quick-start/)

**需要注意的是：不支持高版本jdk，最好1.8u202，需要修改启动jvm参数，默认8g + 4g**

## rocketmq可视化控制台安装
[https://github.com/apache/rocketmq-externals](https://github.com/apache/rocketmq-externals)
1. 下载解压进入rocketmq-console文件夹，修改配置文件
`rocketmq.config.namesrvAddr=127.0.0.1:9876`

2.mvn打包
```
mvn clean package -Dmaven.test.skip=true
```

## 项目安装
1. 打包
```
mvn clean package -DskipTests=true
```