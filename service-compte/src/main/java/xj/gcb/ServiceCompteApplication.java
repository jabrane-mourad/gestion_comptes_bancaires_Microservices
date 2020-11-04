package xj.gcb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xj.gcb.dao.CompteRepository;
import xj.gcb.entities.CompteCourant;
import xj.gcb.entities.CompteEpargne;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ServiceCompteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCompteApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            Stream.of("A","B","C").forEach(c->{
                    compteRepository.save(new CompteCourant(c,new Date(),15.2,45.2));
                    compteRepository.save(new CompteEpargne(c+c,new Date(),1.2,4.2));

            });


        };

    }

}
