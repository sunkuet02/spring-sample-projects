package com.sunkuet02.springboot2.client.tomcatdeploy.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ConverterTest {

    @Test
    public void jsonStringToPojo() throws IOException {
        String jsonString = "{\"name\": \"sun\"}";

        ConverterTest.TestMapper mapper = Converter.jsonStringToPojo(jsonString, ConverterTest.TestMapper.class);

        Assert.assertEquals("sun", mapper.getName());
    }

    public static class TestMapper {
        String name;

        public TestMapper() {
        }

        public TestMapper(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}