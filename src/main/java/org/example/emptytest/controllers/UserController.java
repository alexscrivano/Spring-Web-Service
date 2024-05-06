package org.example.emptytest.controllers;

import org.example.emptytest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.emptytest.services.MyService;
import org.example.emptytest.exceptions.UserAlreadyExitstException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private MyService service;

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        try{
            User added = service.userRegistration(user);
            return new ResponseEntity(added, HttpStatus.OK);
        }catch (UserAlreadyExitstException e){
            return new ResponseEntity<>("USER ALREADY EXISTS", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity adduser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        try{
            User u = new User();
            u.setUsername(username);
            u.setEmail(email);
            u.setPassword(password);
            User added = service.userRegistration(u);
            return new ResponseEntity(added, HttpStatus.OK);
        }catch (UserAlreadyExitstException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users-list")
    public ResponseEntity getUsers() {
        List<User> body = service.findUsers();
        if(body.isEmpty()){
            return new ResponseEntity<>("No Users", HttpStatus.OK);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
