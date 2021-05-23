package com.iweb.backend.controllers;

import com.iweb.backend.dto.MessageResponse;
import com.iweb.backend.dto.WebsiteResponse;
import com.iweb.backend.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iweb")
public class webReturnController {

    @Autowired
    WebsiteService websiteService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getWebsite(@PathVariable("name") String  name){
        if(StringUtils.isEmpty(name)){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Website doesn't Exits"));
        }
        String website = websiteService.getWebsiteByName(name);
        return ResponseEntity.ok(website);

    }
}
