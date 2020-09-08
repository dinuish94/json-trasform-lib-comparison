package com.example.json.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;
import org.springframework.stereotype.Service;

@Service
public class JsltService extends JsonTransformService {

    @Override
    public Object transform() throws Exception {

        JsonNode input = readInputJsonAsJsonNode();
        Expression jslt = Parser.compileString(readTemplate("jslt"));
        JsonNode result = jslt.apply(input);
        return jsonNodeToJsonString(result);
    }
}
