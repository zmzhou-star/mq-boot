# mq-boot
kafka，rocketmq + spring boot消息队列示例

## rocketmq安装
[http://rocketmq.apache.org/docs/quick-start/](http://rocketmq.apache.org/docs/quick-start/)

**需要注意的是：不支持高版本jdk，最好1.8u202，需要修改启动jvm参数，默认8g + 4g**

### rocketmq可视化控制台安装
[https://github.com/apache/rocketmq-externals](https://github.com/apache/rocketmq-externals)
1. 下载解压进入rocketmq-console文件夹，修改配置文件
`rocketmq.config.namesrvAddr=127.0.0.1:9876`

2. mvn打包
```
mvn clean package -Dmaven.test.skip=true
```


## kafka安装
1. 下载 [http://kafka.apache.org/downloads](http://kafka.apache.org/downloads)
2. 解压
```
tar -zxvf kafka_2.13-2.7.0.tgz
cd kafka_2.13-2.7.0/
```
3. 修改 **kafka-server** 的配置文件
```
vim config/server.properties

broker.id=0
log.dir=/data/kafka/logs-0
```
4. 后台启动 zookeeper
```
bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
```
5. 后台启动 Kafka 服务
```
bin/kafka-server-start.sh -daemon config/server.properties
```
6. 使用 kafka-topics.sh 创建单分区单副本的 topic test
```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```
7. 查看 topic 列表
```
bin/kafka-topics.sh --list --zookeeper localhost:2181
```

**如果报错：Error connecting to node zmzhou-130:9092 (id: 0 rack: null) java.net.UnknownHostException: zmzhou-130** 

本机hosts文件添加域名映射，或者修改**config/server.properties**的两行默认配置，即可通过外网连接服务器Kafka，问题解决：
```
# 允许外部端口连接                                            
listeners=PLAINTEXT://0.0.0.0:9092  
# 外部代理地址                                                
advertised.listeners=PLAINTEXT://192.168.163.130:9092
```


## 项目安装
1. 打包
```
mvn clean package -DskipTests=true
```