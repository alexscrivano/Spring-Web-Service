package org.example.emptytest.services;

import jakarta.persistence.EntityManager;
import org.example.emptytest.entities.User;
import org.example.emptytest.repositories.UserRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.emptytest.exceptions.UserAlreadyExitstException;

import java.util.List;

@Service
public class MyService {
    @Autowired
    UserRepository userRepository;
    @Transactional(readOnly=false, propagation = Propagation.REQUIRED)
    public User userRegistration(User user) throws UserAlreadyExitstException {
        if(userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword())) {
            throw new UserAlreadyExitstException("User: " + user.getUsername() + " already exists");
        }
        return userRepository.save(user);
    }

    public List<User> findByEmail(String email) { return userRepository.findByEmail(email); }
    public List<User> findAllByUsername(String username) {return userRepository.findAllByUsername(username); }
    @Transactional(readOnly=true)
    public List<User> findUsers() { return userRepository.findAll(); }
}
