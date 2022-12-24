package com.spring.rabbitmq.spring.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RmqConfig {
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("test.topic");
    }
    @Bean
    public Queue redQueue(){
        return new Queue("red_queue");
    }
    @Bean
    public Queue yellowQueue(){
        return new Queue("yellow_queue");
    }
    @Bean
    public Queue greenQueue(){
        return new Queue("green_queue");
    }
    @Bean
    public Binding redBinding(TopicExchange topic, Queue redQueue){
        return BindingBuilder.bind(redQueue)
                .to(topic)
                .with("*.red");
    }
    @Bean
    public Binding yellowBinding(TopicExchange topic, Queue yellowQueue){
        return BindingBuilder.bind(yellowQueue)
                .to(topic)
                .with("*.yellow");
    }
    @Bean
    public Binding greenBinding(TopicExchange topic, Queue greenQueue){
        return BindingBuilder.bind(greenQueue)
                .to(topic)
                .with("*.green");
    }
}
