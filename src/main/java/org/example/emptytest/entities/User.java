package org.example.emptytest.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.management.ConstructorParameters;

@Getter
@Setter
@Entity
@Table(name="users", schema="usersdb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false)
    private long id;

    @Basic
    @Column(name="user_name")
    private String username;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

}
