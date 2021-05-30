package com.iweb.backend.controllers;

import com.iweb.backend.dto.MessageResponse;
import com.iweb.backend.models.User;
import com.iweb.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long  id){
        User user = new User();
        if (id != null) {
           user =  userRepository.findByI(id);
           user.setPassword("-");
        }else{
            return ResponseEntity.badRequest().body(new MessageResponse("no users found"));
        }
        return ResponseEntity.ok(user);

    }
}
