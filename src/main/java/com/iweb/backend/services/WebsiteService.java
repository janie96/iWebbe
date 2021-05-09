package com.iweb.backend.services;

import com.iweb.backend.dto.TypeResponse;
import com.iweb.backend.dto.WebsiteResponse;
import com.iweb.backend.models.User;
import com.iweb.backend.models.Website;
import com.iweb.backend.repository.UserRepository;
import com.iweb.backend.repository.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebsiteService {

    @Autowired
    WebsiteRepository websiteRepository;

    @Autowired
    UserRepository userRepository;

    public List<WebsiteResponse> getWebsiteList(Long user){

        List<Website> websiteList =websiteRepository.findAllByUser(user);
        List<WebsiteResponse> websiteResponses = new ArrayList<>();
        for(Website w:websiteList){
            WebsiteResponse web = new WebsiteResponse();
            web.setId(w.getId());
            web.setName(w.getName());
            web.setType(w.getType());
            web.setUser(user);
            web.setContent(w.getContent());
            websiteResponses.add(web);
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
        User user = userRepository.findByI(w.getUser());
        web.setName(w.getName());
        web.setType(w.getType());
        web.setContent(w.getContent());
        web.setUser(user);
        web.setId(id);
        Website website = websiteRepository.save(web);
        w.setId(website.getId());
        return w;
    }
}
