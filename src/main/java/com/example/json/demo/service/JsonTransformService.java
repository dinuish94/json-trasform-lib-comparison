package com.example.json.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    private final ObjectMapper objectMapper = new ObjectMapper();

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

    final JsonNode readInputJsonAsJsonNode() throws IOException {

        String inputJsonString = readInputJsonAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(inputJsonString);
    }

    final String jsonNodeToJsonString(JsonNode jsonNode) throws JsonProcessingException {

        if (jsonNode == null) {
            return "Error";
        } else {
            return objectMapper.writeValueAsString(jsonNode);
        }
    }
}
