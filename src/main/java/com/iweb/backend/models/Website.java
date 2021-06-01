package com.iweb.backend.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String type;

    private String content;

    @Nullable
    private String searchKeys;

    @Nullable
    private String expectedUsers;

    @Nullable
    private String serverLocation;

    @Nullable
    private String domainName;

    @Nullable
    private String contentStorage;

    @Nullable
    private String serverType;

    @Nullable
    private String backUps;

    @Nullable
    private String preference;

    @Nullable
    private String url;

    public Website(Long id, String name, User user, String type, String content) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.type = type;
        this.content = content;
    }

    public Website() {
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    @Nullable
    public String getSearchKeys() {
        return searchKeys;
    }

    public void setSearchKeys(@Nullable String searchKeys) {
        this.searchKeys = searchKeys;
    }

    @Nullable
    public String getExpectedUsers() {
        return expectedUsers;
    }

    public void setExpectedUsers(@Nullable String expectedUsers) {
        this.expectedUsers = expectedUsers;
    }

    @Nullable
    public String getServerLocation() {
        return serverLocation;
    }

    public void setServerLocation(@Nullable String serverLocation) {
        this.serverLocation = serverLocation;
    }

    @Nullable
    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(@Nullable String domainName) {
        this.domainName = domainName;
    }

    @Nullable
    public String getContentStorage() {
        return contentStorage;
    }

    public void setContentStorage(@Nullable String contentStorage) {
        this.contentStorage = contentStorage;
    }

    @Nullable
    public String getServerType() {
        return serverType;
    }

    public void setServerType(@Nullable String serverType) {
        this.serverType = serverType;
    }

    @Nullable
    public String getBackUps() {
        return backUps;
    }

    public void setBackUps(@Nullable String backUps) {
        this.backUps = backUps;
    }

    @Nullable
    public String getPreference() {
        return preference;
    }

    public void setPreference(@Nullable String preference) {
        this.preference = preference;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public void setUrl(@Nullable String url) {
        this.url = url;
    }
}
