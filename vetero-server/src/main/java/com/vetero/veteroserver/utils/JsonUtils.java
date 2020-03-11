package com.vetero.veteroserver.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetero.veteroserver.exceptions.WrongJsonException;
import com.vetero.veteroserver.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;


@ApplicationScope
@Component
public class JsonUtils {
    @Autowired
    private Logger logger;

    private ObjectMapper objectMapper;

    @PostConstruct
    private void init() {
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("Error while converting JSON to Object " + clazz.getName(), e);
        }
        throw new WrongJsonException("Can not deserialize JSON to Object!" + json + " to class " + clazz.getName());
    }

    public <T> T fromJson(String json, TypeReference type) {
        try {
            return (T)objectMapper.readValue(json, type);
        } catch (Exception e) {
            logger.error("Error while convert JSON to Object " + type.getType().getTypeName(), e);
        }
        throw new WrongJsonException("Cant deserialize JSON to Object!" + json + " to class " + type.getType().getTypeName());
    }

    public <T> T prepareDTO(Object rawData, Class type) {
        return (T) objectMapper.convertValue(rawData, type);
}
    }
