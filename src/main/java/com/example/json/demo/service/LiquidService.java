package com.example.json.demo.service;

import liqp.Template;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class LiquidService extends JsonTransformService {

    @Override
    public Object transform() throws IOException {

        Template template = Template.parse(readTemplate("liquid"));

        Map<String, Object> data = new HashMap<>();
        data.put("crsConfirmationId", "24955269");
        data.put("crsPageNumber", "2345");
        data.put("propertyId", "JEDHR");
        data.put("brandId", "HYATT");
        data.put("brandName", "ABC");
        data.put("brandLogo", "null");
        data.put("reservationAction", "ADD");
        data.put("transactionId", "2801913");

        return template.render(data);
    }
}
