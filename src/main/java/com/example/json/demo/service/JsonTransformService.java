package com.example.json.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public abstract class JsonTransformService {

    @Autowired
    ResourceLoader resourceLoader;

    public abstract Object transform() throws IOException;

    final String readFileAsString(String fileName) throws IOException {

        File resource = resourceLoader.getResource("classpath:" + fileName).getFile();
        return new String(Files.readAllBytes(resource.toPath()));
    }

    final String readTemplate(String templateName) throws IOException {

        return readFileAsString("template/" + templateName);
    }
}
