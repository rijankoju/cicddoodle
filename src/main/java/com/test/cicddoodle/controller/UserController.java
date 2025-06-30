package com.test.cicddoodle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {


     @GetMapping("/users")
     public ResponseEntity<?> getUserList() {
         return ResponseEntity.ok("List of users");
     }
}
