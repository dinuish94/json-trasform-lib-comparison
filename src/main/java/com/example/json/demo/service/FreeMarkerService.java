package com.example.json.demo.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Service
public class FreeMarkerService extends JsonTransformService {

    @Override
    public Object transform() {

        Configuration cfg = new Configuration(new Version(2, 3, 20));
        cfg.setClassForTemplateLoading(this.getClass(), "/");

        try {
            Template template = cfg.getTemplate("template/freemarker.ftl");

            Map<String, Object> data = new HashMap<>();
            data.put("crsConfirmationId", "24955269");
            data.put("crsPageNumber", "null");
            data.put("propertyId", "JEDHR");
            data.put("brandId", "HYATT");
            data.put("brandName", "null");
            data.put("brandLogo", "null");
            data.put("reservationAction", "ADD");
            data.put("transactionId", "2801913");

            Writer out = new StringWriter();
            template.process(data, out);
            return out.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        return null;
    }
}
