package com.example.json.demo.service;

import com.api.jsonata4java.expressions.Expressions;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonataService extends JsonTransformService {

    @Override
    public Object transform() throws Exception {

        JsonNode jsonObj = readInputJsonAsObject();
        String expression = readTemplate("jsonata").replaceAll("[\r\n]+", " ");
        Expressions expr = Expressions.parse(expression);
        JsonNode result = expr.evaluate(jsonObj);
        if (result == null) {
            return "** no match **";
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        }
    }
}
