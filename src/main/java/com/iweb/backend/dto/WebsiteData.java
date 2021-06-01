package com.iweb.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebsiteData {
    private Long id;
    private String name;
    private Long user;
    private String searchKeys;
    private String expectedUsers;
    private String serverLocation;
    private String domainName;
    private String contentStorage;
    private String serverType;
    private String backUps;
    private String type;
    private String preference;
    private int visits;

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

    public String getSearchKeys() {
        return searchKeys;
    }

    public void setSearchKeys(String searchKeys) {
        this.searchKeys = searchKeys;
    }

    public String getExpectedUsers() {
        return expectedUsers;
    }

    public void setExpectedUsers(String expectedUsers) {
        this.expectedUsers = expectedUsers;
    }

    public String getServerLocation() {
        return serverLocation;
    }

    public void setServerLocation(String serverLocation) {
        this.serverLocation = serverLocation;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getContentStorage() {
        return contentStorage;
    }

    public void setContentStorage(String contentStorage) {
        this.contentStorage = contentStorage;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getBackUps() {
        return backUps;
    }

    public void setBackUps(String backUps) {
        this.backUps = backUps;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
