package com.ttl.redispubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisher implements MessagePublisher{
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MessageListener messageListener;

    @Autowired
    RedisMessageListenerContainer container;

    @Autowired
    RedisConnectionFactory connectionFactory;

    @Scheduled(fixedDelay = 1000)
    public void publish(Infos infos){

        ChannelTopic channelTopic = new ChannelTopic(infos.getAppName());
        container.addMessageListener(messageListener,channelTopic);
        container.start();
        redisTemplate.convertAndSend(infos.getAppName(), infos);
    }
}
