package com.vetero.veteroserver.logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Member;

@Configuration
public class LoggerCreator {
    @Bean
    public Logger produceLog(InjectionPoint injectionPoint) {
        Member member = injectionPoint.getMember();
        if (member != null) {
            return new Logger(LoggerFactory.getLogger(member.getDeclaringClass()));
        }
        return new Logger(LoggerFactory.getLogger("StaticLogger"));
    }
}
