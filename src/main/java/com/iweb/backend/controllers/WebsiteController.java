package com.iweb.backend.controllers;

import com.iweb.backend.dto.MessageResponse;
import com.iweb.backend.dto.TypeResponse;
import com.iweb.backend.dto.WebsiteResponse;
import com.iweb.backend.services.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebsiteController {

    private final Path root = Paths.get("C:\\xampp\\htdocs\\image");

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

    @PostMapping("/web/type")
    public ResponseEntity<?> saveType(@Valid @RequestBody TypeResponse t){
        TypeResponse type  = websiteService.saveType(t);
        return ResponseEntity.ok(type);

    }

    @PostMapping("/web/{id}")
    public ResponseEntity<?> updateWebsite(@Valid @RequestBody WebsiteResponse w,@PathVariable("id") Long id){
        if(id == null){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Id is invalid!"));
        }
        WebsiteResponse web  = websiteService.update(id,w);
        return ResponseEntity.ok(web);

    }

    @RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
    public ResponseEntity<?> saveImage(@RequestParam("file") MultipartFile file) {
        String filename = "";
        try {
            if(!file.isEmpty()){
                filename = Long.toString(new Date().getTime()).trim()+file.getOriginalFilename()  ;
                Files.copy(file.getInputStream(), this.root.resolve(filename));
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        return ResponseEntity.ok(filename);
    }


}
