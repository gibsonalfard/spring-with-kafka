package xyz.ilhamgibran.spring.springmongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
public class MahasiswaConsumer {
    public static final Logger logger = LoggerFactory.getLogger(MahasiswaConsumer.class);

    @Autowired
    private MahasiswaRepository repository;

    @StreamListener(target = Sink.INPUT)
    public void consume(String message){
        logger.info("Receive a String Message: "+message);
        try {
            Mahasiswa usr = new ObjectMapper().readValue(message, Mahasiswa.class);
            logger.info("NIM: " + usr.getNim());
            logger.info("Nama: " + usr.getName());
            logger.info("SKS Selesai: " + usr.getSksTake());

            repository.save(new Mahasiswa(usr.getNim(), usr.getName(), usr.getSksTake()));

            System.out.println("Mahasiswa found with findAll():");
            System.out.println("-------------------------------");
            for (Mahasiswa mhs : repository.findAll()){
                System.out.println(mhs);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='user'")
    public void consumeMahasiswa(@Payload Mahasiswa mhs){
        logger.info("Receive a complex message: ");
        logger.info("NIM: " + mhs.getNim());
        logger.info("Nama: " + mhs.getName());
        logger.info("SKS Selesai: " + mhs.getSksTake());
    }

}
