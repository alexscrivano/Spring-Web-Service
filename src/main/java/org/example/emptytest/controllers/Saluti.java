package org.example.emptytest.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saluti")
@CrossOrigin
public class Saluti {
    @GetMapping("/hello-world")
    public ResponseEntity<String> sayHello() {
        String message = "Hello World!";
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("{\"message\":\"" + message + "\"}");
    }
}
