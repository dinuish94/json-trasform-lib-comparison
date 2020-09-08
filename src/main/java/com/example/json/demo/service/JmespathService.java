package com.example.json.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.burt.jmespath.Expression;
import io.burt.jmespath.JmesPath;
import io.burt.jmespath.jackson.JacksonRuntime;
import org.springframework.stereotype.Service;

@Service
public class JmespathService extends JsonTransformService {

    @Override
    public Object transform() throws Exception {

        JmesPath<JsonNode> jmespath = new JacksonRuntime();
        Expression<JsonNode> expression = jmespath.compile(readTemplate("jmespath"));
        JsonNode input = readInputJsonAsJsonNode();
        JsonNode result = expression.search(input);
        return jsonNodeToJsonString(result);
    }
}
