package com.SparkleApp.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String homeAddress;
    private String specialInstructions;
    private LocalDateTime sendAt;
    private LocalDateTime updatedAt;
    @OneToMany
    private List<OrderPlacement> listOfOrders;
}
