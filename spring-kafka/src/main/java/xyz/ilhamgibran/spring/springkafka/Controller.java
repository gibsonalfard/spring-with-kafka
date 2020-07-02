package xyz.ilhamgibran.spring.springkafka;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Producer producer;
    public Controller(Producer producer){
        super();
        this.producer = producer;
    }

    @RequestMapping(value = "/sendMessage/complex", method = RequestMethod.POST)
    public String publishMessageComplex(@RequestBody ChatMessage payload){
        payload.setTime(System.currentTimeMillis());
        producer.getSource()
                .output()
                .send(MessageBuilder.withPayload(payload)
                    .setHeader("type","chat")
                    .build());

        return "success";
    }

    @RequestMapping(value = "/sendMessage/string", method = RequestMethod.POST)
    public String publishMessageSimple(@RequestBody String payload){
        producer.getSource()
                .output()
                .send(MessageBuilder.withPayload(payload)
                        .setHeader("type","string")
                        .build());
        return "success";
    }

    @RequestMapping(value = "/sendMessage/example", method = RequestMethod.GET)
    public String publishDummyMessage(){
        User usr = new User("171524012", "Ilham Gibran Achmad Mudzakir", 102);

        producer.getSource()
                .output()
                .send(MessageBuilder.withPayload(usr)
                        .setHeader("type","user")
                        .build());

        return "success ??";
    }
}
