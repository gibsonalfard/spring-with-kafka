package xyz.ilhamgibran.spring.springmysql.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import xyz.ilhamgibran.spring.springmysql.model.Mahasiswa;
import xyz.ilhamgibran.spring.springmysql.repository.MahasiswaRepository;

@EnableBinding(Sink.class)
public class ConsumerController {
    @Autowired
    private MahasiswaRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @StreamListener(target = Sink.INPUT)
    public void stringConsume(String message){
        try {
            Mahasiswa usr = new ObjectMapper().readValue(message, Mahasiswa.class);
            logger.info("NIM: " + usr.getNim());
            logger.info("Nama: " + usr.getName());
            logger.info("SKS Selesai: " + usr.getSksTake());

            repository.save(new Mahasiswa(usr.getNim(), usr.getName(), usr.getSksTake()));
//
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
