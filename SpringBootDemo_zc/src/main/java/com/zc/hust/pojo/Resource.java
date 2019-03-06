package com.zc.hust.pojo;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:resource.properties")
@ConfigurationProperties(prefix = "com.imooc.opensource")
public class Resource {
    String name;
    String website;
    String language;

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getLanguage() {
        return language;
    }
}
