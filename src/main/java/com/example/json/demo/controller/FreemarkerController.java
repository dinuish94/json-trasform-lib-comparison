package com.example.json.demo.controller;

import com.example.json.demo.service.FreeMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    FreeMarkerService freeMarkerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get() {

        return new ResponseEntity(freeMarkerService.transform(), HttpStatus.OK);
    }
}
