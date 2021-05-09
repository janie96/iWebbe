package com.iweb.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iweb.backend.models.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebsiteResponse {

    private Long id;
    private String name;
    private Long user;
    private String type;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
