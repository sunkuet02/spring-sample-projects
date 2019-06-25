package com.sunkuet02.springboot2.client.tomcatdeploy.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public abstract class Converter {

    public static <T> T jsonStringToPojo(String objectString, Class<T> object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(objectString, object);
    }
}
