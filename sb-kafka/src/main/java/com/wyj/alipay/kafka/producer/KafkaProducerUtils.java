package com.wyj.alipay.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created
 * Author: wyj
 * Date: 2019/3/11
 */
public class KafkaProducerUtils {


    public static void main(String[] args) {
        produce();
    }

    private static void produce() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for(int i=0; i<100; i++) {
            producer.send(new ProducerRecord<>("my-topic", "key"+i, "value"+i));
        }

        producer.close();
    }

    private static void delayMsg() {
//        ScheduledThreadPoolExecutor pool =
    }
}
