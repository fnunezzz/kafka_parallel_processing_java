package com.github.fnunezzz.kafkaparallelprocessingjava.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.schema.BookMessage;
import com.github.fnunezzz.kafkaparallelprocessingjava.service.CatalogService;

@Service
public class BookConsumer {
    

    @Autowired
    private CatalogService catalogService;

    @KafkaListener(id = "kafka-parallel-processing-java", topics = "books", containerFactory = "kafkaListenerContainerFactory", autoStartup = "true")
    public void read(ConsumerRecord<String, BookMessage> record) throws Exception {
        // String key = record.key();
        BookMessage history = record.value();
        
        this.catalogService.createCatalog(history);


    }

}
