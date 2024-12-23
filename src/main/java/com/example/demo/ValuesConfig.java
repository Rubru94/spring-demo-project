package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.example.demo.models.YamlPropertySourceFactory;

@Configuration
@ConfigurationProperties(prefix = "yaml")
@PropertySources({
                @PropertySource(value = "classpath:values.yaml", factory = YamlPropertySourceFactory.class)
})

public class ValuesConfig {

}
