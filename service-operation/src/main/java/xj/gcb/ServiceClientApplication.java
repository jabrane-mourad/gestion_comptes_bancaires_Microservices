package xj.gcb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xj.gcb.dao.OperationRepository;
import xj.gcb.entities.Operation;
import xj.gcb.entities.Retrait;
import xj.gcb.entities.Versement;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);
    }

    @Bean
    CommandLineRunner start(OperationRepository operationRepository ){
        return args -> {
            Stream.of("1","2","3").forEach(c->{
                operationRepository.save(new Retrait(null,new Date(),15.2));
                operationRepository.save(new Versement(null,new Date(),1.2));

            });


        };

    }

}
