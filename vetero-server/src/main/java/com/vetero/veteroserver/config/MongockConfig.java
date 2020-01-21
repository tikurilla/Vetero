package com.vetero.veteroserver.config;

import com.github.cloudyrock.mongock.SpringMongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MongockConfig {
    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Autowired
    private MongoConfig mongoConfig;

    @Bean
    public SpringMongock mongock(){
        MongoClient mongoClient = mongoConfig.mongoClient();
        return new SpringMongockBuilder(mongoClient, databaseName, "com.vetero.veteroserver.changelogs")
                .setLockQuickConfig()
                .build();
    }
}
