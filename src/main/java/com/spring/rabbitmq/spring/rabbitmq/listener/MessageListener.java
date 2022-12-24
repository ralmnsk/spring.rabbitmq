package com.spring.rabbitmq.spring.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {
    @RabbitListener(queues = "#{redQueue.name}")
    public void receiveRedMessage(String in) {
        log.info(in);
    }
    @RabbitListener(queues = "#{yellowQueue.name}")
    public void yellowRedMessage(String in) {
        log.info(in);
    }
    @RabbitListener(queues = "#{greenQueue.name}")
    public void receiveGreenMessage(String in) {
        log.info(in);
    }
}
