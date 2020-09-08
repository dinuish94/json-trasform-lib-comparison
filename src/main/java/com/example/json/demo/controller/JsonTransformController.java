package com.example.json.demo.controller;

import com.example.json.demo.service.FreeMarkerService;
import com.example.json.demo.service.JmespathService;
import com.example.json.demo.service.JoltService;
import com.example.json.demo.service.JsltService;
import com.example.json.demo.service.JsonataService;
import com.example.json.demo.service.LiquidService;
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
    @Autowired
    LiquidService liquidService;
    @Autowired
    JsonataService jsonataService;
    @Autowired
    JmespathService jmespathService;
    @Autowired
    JsltService jsltService;

    @GetMapping(path = "/jolt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithJolt() {

        return new ResponseEntity(joltService.transform(), HttpStatus.OK);
    }

    @GetMapping(path = "/freemarker", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithFreemarker() {

        return new ResponseEntity(freeMarkerService.transform(), HttpStatus.OK);
    }

    @GetMapping(path = "/liquid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithLiquid() throws Exception {

        return new ResponseEntity(liquidService.transform(), HttpStatus.OK);
    }

    @GetMapping(path = "/jsonata", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithJsonata() throws Exception {

        return new ResponseEntity(jsonataService.transform(), HttpStatus.OK);
    }

    @GetMapping(path = "/jmespath", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithJmespath() throws Exception {

        return new ResponseEntity(jmespathService.transform(), HttpStatus.OK);
    }

    @GetMapping(path = "/jslt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity transformWithJslt() throws Exception {

        return new ResponseEntity(jsltService.transform(), HttpStatus.OK);
    }

}
