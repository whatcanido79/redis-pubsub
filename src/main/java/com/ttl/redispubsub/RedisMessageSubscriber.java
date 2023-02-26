package com.ttl.redispubsub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.scheduling.annotation.Scheduled;

public class RedisMessageSubscriber implements MessageListener {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Scheduled(fixedDelay = 10000)
    public void onMessage(Message message, byte[] pattern) {
        try {
            Infos infos = objectMapper.readValue(message.toString(), Infos.class);
            System.out.println(infos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
