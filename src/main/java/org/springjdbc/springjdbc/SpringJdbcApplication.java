package org.springjdbc.springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springjdbc.springjdbc.models.Alien;
import org.springjdbc.springjdbc.repository.AlienRepository;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {
    //add password in application.properties before use

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringJdbcApplication.class, args);

        Alien a1 = ctx.getBean(Alien.class);
        a1.setName("Alien1");
        a1.setId(2);
        a1.setTech("springboot");

        AlienRepository repo = ctx.getBean(AlienRepository.class);
//        repo.save(a1);
        List<Alien> list = repo.getAllAliens();

        for(Alien a : list){
            System.out.println(a);
        }
    }


}
