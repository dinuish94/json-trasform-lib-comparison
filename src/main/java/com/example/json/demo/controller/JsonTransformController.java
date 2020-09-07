package com.example.json.demo.controller;

import com.example.json.demo.service.FreeMarkerService;
import com.example.json.demo.service.JoltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTransformController {

    @Autowired
    JoltService joltService;

    @Autowired
    FreeMarkerService freeMarkerService;

    @GetMapping(path = "/jolt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithJolt() {

        return new ResponseEntity(joltService.transform(), HttpStatus.OK);
    }

    @GetMapping(path = "/freemarker", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithFreemarker() {

        return new ResponseEntity(freeMarkerService.transform(), HttpStatus.OK);
    }
}
