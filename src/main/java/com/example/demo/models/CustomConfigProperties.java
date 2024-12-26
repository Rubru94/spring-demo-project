package com.example.demo.models;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfigProperties {

    private Map<String, Object> valuesMap;

    public Map<String, Object> getValuesMap() {
        return valuesMap;
    }

    public void setValuesMap(Map<String, Object> valuesMap) {
        this.valuesMap = valuesMap;
    }
}
