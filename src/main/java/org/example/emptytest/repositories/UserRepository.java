package org.example.emptytest.repositories;

import org.example.emptytest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByUsername(String username);
    List<User> findByEmail(String email);
    boolean existsByUsernameAndPassword(String username, String password);
}
