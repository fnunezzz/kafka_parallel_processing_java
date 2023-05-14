package com.github.fnunezzz.kafkaparallelprocessingjava.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.schema.BookMessage;

@Service
public class BookConsumer {
    

    @KafkaListener(id = "kafka-parallel-processing-java", topics = "books", containerFactory = "kafkaListenerContainerFactory", autoStartup = "true")
    public void read(ConsumerRecord<String, BookMessage> record) throws Exception {
        String key = record.key();
        BookMessage history=record.value();
        System.out.println("Avro message received for key : "+key+ " value : "+history.toString());


    }

}
