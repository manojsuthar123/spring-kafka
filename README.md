# spring-kafka
Steps to start with Kafka
## Download kafka from
https://www.apache.org/dyn/closer.cgi?path=/kafka/3.2.1/kafka_2.13-3.2.1.tgz

## Kafka quick start guide
https://kafka.apache.org/quickstart

## Start server
(All are in Windows directory)
1. Start zookeeper on windows

  ```.\zookeeper-server-start.bat F:\Software\kafka\config\zookeeper.properties```

2. Start kafka server

  ```.\kafka-server-start.bat F:\Software\kafka\config\server.properties```

3. Create a topic

  ```.\kafka-topics.bat --create --topic <topic-name> --bootstrap-server localhost:9092```

4. Details about topic

  ```.\kafka-topics.bat --describe --topic <topic-name> --bootstrap-server localhost:9092```

5. Write event on topic (Producer)

  ```.\kafka-console-producer.bat --topic <topic-name> --bootstrap-server localhost:9092```

6. Read the events (Consumer)

  ```.\kafka-console-consumer.bat --topic <topic-name> --from-beginning --bootstrap-server localhost:9092```
