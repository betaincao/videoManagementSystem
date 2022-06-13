package com.example.videomanagementsystem.kafkamq.consumer;

import com.example.videomanagementsystem.kafkamq.mqBean.ObjRecognitionToSystemBean;
import com.example.videomanagementsystem.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class ObjRecognitionToSystemListener {

    @Value("${kafka.objRecognition2System-topic}")
    private String topicName;

    /**
     * 监听消费
     * @param record
     * @throws IOException
     */
    @KafkaListener(topics = "${kafka.objRecognition2System-topic}")
    public void listen(ConsumerRecord<?, ?> record) throws IOException {
        if (!topicName.equals(record.topic())) {
            return;
        }

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (!kafkaMessage.isPresent()) {
            return;
        }

        ObjRecognitionToSystemBean objRecognitionToSystemBean = JacksonUtil.strToBean((String) kafkaMessage.get(), ObjRecognitionToSystemBean.class);
        if (objRecognitionToSystemBean == null) {
            return;
        }


    }
}
