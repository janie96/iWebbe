package com.iweb.backend.services;

import com.iweb.backend.dto.TypeResponse;
import com.iweb.backend.dto.WebsiteData;
import com.iweb.backend.dto.WebsiteResponse;
import com.iweb.backend.models.Bug;
import com.iweb.backend.models.User;
import com.iweb.backend.models.Website;
import com.iweb.backend.repository.BugRepository;
import com.iweb.backend.repository.UserRepository;
import com.iweb.backend.repository.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService {

    @Autowired
    WebsiteRepository websiteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BugRepository bugRepository;

    public List<WebsiteData> getWebsiteList(Long user){

        List<Website> websiteList =websiteRepository.findAllByUser(user);
        List<WebsiteData> websiteResponses = new ArrayList<>();
        for(Website web:websiteList){
            WebsiteData w = new WebsiteData();
            w.setId(web.getId());
            w.setName(web.getName());
            w.setUser(web.getUser().getId());
            w.setSearchKeys(web.getSearchKeys());
            w.setExpectedUsers(web.getExpectedUsers());
            w.setServerLocation(web.getServerLocation());
            w.setDomainName(web.getDomainName());
            w.setContentStorage(web.getContentStorage());
            w.setServerType(web.getServerType());
            w.setBackUps(web.getBackUps());
            w.setType(web.getType());
            w.setPreference(web.getPreference());
            websiteResponses.add(w);
        }
        return websiteResponses;
    }

    public WebsiteResponse getWebsite(Long id){
        Website w = websiteRepository.findByI(id);
        WebsiteResponse web = new WebsiteResponse();
        web.setId(w.getId());
        web.setName(w.getName());
        web.setType(w.getType());
        web.setUser(w.getUser().getId());
        web.setContent(w.getContent());
        return web;
    }

    public String getWebsiteByName(String name){
        String w = "NOT FOUND";
        Optional<Website> website = websiteRepository.findByName(name);
        if(website.isPresent()){
            w = website.get().getContent();
        }
        return w;
    }

    public WebsiteResponse save(WebsiteResponse w){

        Website web = new Website();
        User user = userRepository.findByI(w.getUser());
        web.setName(w.getName());
        web.setType(w.getType());
        web.setContent(w.getContent());
        web.setUser(user);
        Website website = websiteRepository.save(web);
        w.setId(website.getId());
        return w;
    }

    public TypeResponse saveType(TypeResponse t){

        Website web = new Website();
        User user = userRepository.findByI(t.getUser());
        web.setType(t.getType());
        web.setUser(user);
        Website website = websiteRepository.save(web);
        t.setId(website.getId());
        return t;
    }

    public WebsiteResponse update(Long id,WebsiteResponse w){

        Website web = websiteRepository.findByI(id);
        if(web == null){
            return null;
        }
        web.setName(w.getName());
        web.setType(w.getType());
        web.setContent(w.getContent());
//        web.setUser(user);
//        web.setId(id);
        websiteRepository.save(web);
//        Website website = websiteRepository.save(web);
        w.setId(web.getId());
        return w;
    }

    public WebsiteData updateWebsiteDeployData(Long id,WebsiteData w){
        Website web = websiteRepository.findByI(id);
        web.setName(w.getName());
        web.setType(w.getType());
        web.setSearchKeys(w.getSearchKeys());
        web.setExpectedUsers(w.getExpectedUsers());
        websiteRepository.save(web);
        return w;
    }

    public WebsiteData updateWebsiteServerData(Long id,WebsiteData w){
        Website web = websiteRepository.findByI(id);
        web.setServerLocation(w.getServerLocation());
        web.setContentStorage(w.getContentStorage());
        web.setServerType(w.getServerType());
        web.setBackUps(w.getBackUps());
        websiteRepository.save(web);
        return w;
    }

    public WebsiteData updateWebsitePersonalizedData(Long id,WebsiteData w){
        Website web = websiteRepository.findByI(id);
        web.setPreference(w.getPreference());
        websiteRepository.save(web);
        return w;
    }

    public WebsiteData getAllWebData(Long id){
        Website web = websiteRepository.findByI(id);
        WebsiteData w = new WebsiteData();
        w.setId(web.getId());
        w.setName(web.getName());
        w.setUser(web.getUser().getId());
        w.setSearchKeys(web.getSearchKeys());
        w.setExpectedUsers(web.getExpectedUsers());
        w.setServerLocation(web.getServerLocation());
        w.setDomainName(web.getDomainName());
        w.setContentStorage(web.getContentStorage());
        w.setServerType(web.getServerType());
        w.setBackUps(web.getBackUps());
        w.setType(web.getType());
        w.setPreference(web.getPreference());
        websiteRepository.save(web);
        return w;
    }

    public Bug reportBug(Bug bug){
        bugRepository.save(bug);
        return bug;
    }

    public WebsiteResponse uploadWebsite(Long id){
        Website web = websiteRepository.findByI(id);
        WebsiteResponse w = new WebsiteResponse();
        try {
            FileWriter myWriter  = new FileWriter("C:\\xampp\\htdocs\\iweb\\"+web.getName()+".html");
            myWriter.write(web.getContent());
            myWriter.close();
            web.setUrl("http://localhost/iweb/"+web.getName()+".html");
            websiteRepository.save(web);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        if(web == null){
            return null;
        }
        w.setId(web.getId());
        w.setContent(web.getContent());
        return w;
    }


}
