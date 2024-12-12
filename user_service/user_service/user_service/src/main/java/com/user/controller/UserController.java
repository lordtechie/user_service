package com.user.controller;

import com.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.user.service.UserService;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserService userService;

   @Autowired
   private RestTemplate restTemplate;


@GetMapping("/{userId}")
   public User getUser(@PathVariable("userId") Long userId) {

    User user = userService.getUser(userId);
    List contacts = this.restTemplate.getForObject("http://CONTACT-SERVICE/contact/user/"+user.getUserId(), List.class);

    user.setContacts(contacts);
    return user;
   }

   /*@GetMapping("/{userId}")
   public ResponseEntity<User> getUser(@PathVariable String userId) {
     try {
        User user = userService.getUser(Long.parseLong(userId));
        if (user == null) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
     } catch (Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }


   }*/

    @GetMapping("/check")
    public ResponseEntity<String> checkUser() {

            return ResponseEntity.ok("working");


    }



}
