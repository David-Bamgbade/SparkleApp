package com.SparkleApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Launderer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    @Column(name = "logged_in", nullable = false)
    private Boolean loggedIn;
    private LocalDateTime sendAt;
    private LocalDateTime receivedAt;
    private LocalDateTime createdAt;
}
