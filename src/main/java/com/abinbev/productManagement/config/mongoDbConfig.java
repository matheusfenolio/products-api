package com.abinbev.productManagement.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class mongoDbConfig {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb+srv://dev:D3v164@sandbox.o0b9z.mongodb.net/abinbev?retryWrites=true&w=majority");
    }

    @Bean
    public MongoOperations mongoOperations() {
        return new MongoTemplate(mongoClient(), "abinbev");
    }
}
