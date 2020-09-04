package com.example.json.demo.service;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoltService extends JsonTransformService {

    @Override
    public Object transform() {

        List chainrSpecJSON = JsonUtils.classpathToList("/json/jolt_spec.json");
        Chainr chainr = Chainr.fromSpec(chainrSpecJSON);

        Object inputJSON = JsonUtils.classpathToObject("/json/input.json");

        return chainr.transform(inputJSON);
    }
}
