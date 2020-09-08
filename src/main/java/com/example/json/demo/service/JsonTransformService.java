package com.example.json.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public abstract class JsonTransformService {

    @Autowired
    ResourceLoader resourceLoader;

    public abstract Object transform() throws Exception;

    final String readFileAsString(String fileName) throws IOException {

        File resource = resourceLoader.getResource("classpath:" + fileName).getFile();
        return new String(Files.readAllBytes(resource.toPath()));
    }

    final String readTemplate(String templateName) throws IOException {

        return readFileAsString("template/" + templateName);
    }

    final String readInputJsonAsString() throws IOException {

        File resource = resourceLoader.getResource("classpath:" + "json/input.json").getFile();
        return new String(Files.readAllBytes(resource.toPath()));
    }

    final JsonNode readInputJsonAsObject() throws IOException {

        String inputJsonString = readInputJsonAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(inputJsonString);
    }
}
