package xyz.ilhamgibran.spring.springkafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@EnableBinding(Sink.class)
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @StreamListener(target = Sink.INPUT)
    public void consume(String message){
        logger.info("Receive a String Message: "+message);
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='chat'")
    public void handle(@Payload ChatMessage message){
        final DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withZone(ZoneId.systemDefault());
        final String time =  df.format(Instant.ofEpochMilli(message.getTime()));
        logger.info("Receive a complex message : [{}]: {}", time, message.getContents());
    }
}
