package com.example.json.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.logz.sawmill.Doc;
import io.logz.sawmill.ExecutionResult;
import io.logz.sawmill.Pipeline;
import io.logz.sawmill.PipelineExecutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SwamillService extends JsonTransformService {

    @Override
    public Object transform() throws Exception {

        Pipeline pipeline = new Pipeline.Factory().create(readTemplate("swamill"));

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("message", "testing geoip resolving");
        dataMap.put("ip", "172.217.11.174");

        ObjectMapper objectMapper = new ObjectMapper();
        dataMap = objectMapper.readValue(readInputJsonAsString(), Map.class);

        Doc doc = new Doc(dataMap);
        ExecutionResult executionResult = new PipelineExecutor().execute(pipeline, doc);

        if (executionResult.isSucceeded()) {
            return objectMapper.writeValueAsString(doc.getSource());
        }
        return "fail";
    }
}
