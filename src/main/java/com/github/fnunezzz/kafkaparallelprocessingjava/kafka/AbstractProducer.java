package com.github.fnunezzz.kafkaparallelprocessingjava.kafka;
import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;



public abstract class AbstractProducer<T, E> {
    
    @Autowired
    private KafkaTemplate<String, T> kafkaTemplate;


    protected void send(T model, String topic) throws Exception {
        ListenableFuture<SendResult<String, T>> futureObject = kafkaTemplate.send(topic, model);
        futureObject.addCallback(new ListenableFutureCallback<SendResult<String, T>>() {
            

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }


            @Override
            public void onSuccess(@Nullable SendResult<String, T> result) {
                System.out.println("Message posted");
            }
        });

    }


    public abstract void send(E object) throws Exception;
}
