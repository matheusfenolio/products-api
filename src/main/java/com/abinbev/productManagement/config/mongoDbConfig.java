package com.abinbev.productManagement.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class mongoDbConfig {

    @Value("${productManagement.database.url}")
    String url;

    @Value("${productManagement.database.name}")
    String dbname;

    @Value("${productManagement.database.username}")
    String username;

    @Value("${productManagement.database.password}")
    String password;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://"+username+":"+password+"@"+url+"/"+dbname+"?retryWrites=true&w=majority");
    }

    @Bean
    public MongoOperations mongoOperations() {
        return new MongoTemplate(mongoClient(), "abinbev");
    }
}
