package com.iweb.backend.controllers;

import com.iweb.backend.dto.MessageResponse;
import com.iweb.backend.dto.WebsiteResponse;
import com.iweb.backend.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebsiteController {

    @Autowired
    WebsiteService websiteService;

    @GetMapping("/web/list/{user}")
    public ResponseEntity<?> getList(@PathVariable("user") Long user){
        if(user == null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: User is invalid!"));
        }
        List<WebsiteResponse> w = websiteService.getWebsiteList(user);
        return ResponseEntity.ok(w);

    }

    @GetMapping("/web/{id}")
    public ResponseEntity<?> getWebsite(@PathVariable("id") Long id){
        if(id == null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Id is invalid!"));
        }
        WebsiteResponse w = websiteService.getWebsite(id);
        return ResponseEntity.ok(w);

    }

    @PostMapping("/web")
    public ResponseEntity<?> saveWebsite(@Valid @RequestBody WebsiteResponse w){
        WebsiteResponse web  = websiteService.save(w);
        return ResponseEntity.ok(web);

    }

}
