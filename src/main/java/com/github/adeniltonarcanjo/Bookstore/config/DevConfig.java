package com.github.adeniltonarcanjo.Bookstore.config;


import com.github.adeniltonarcanjo.Bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {


    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instancyDataBase(){

        if(strategy.equalsIgnoreCase("create")){
            this.dbService.dataBaseInstance();

        }
        return false;

    }


}
