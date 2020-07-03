package xyz.ilhamgibran.spring.springkafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public NewTopic kafkaTopic(){
        return TopicBuilder.name("test")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
