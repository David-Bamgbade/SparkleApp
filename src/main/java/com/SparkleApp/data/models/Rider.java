package com.SparkleApp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String confirmPassword;
    private boolean isAvailable;
//    private String riderStatus;

    @Enumerated(EnumType.STRING)
    private RiderStatus riderStatus;



}
