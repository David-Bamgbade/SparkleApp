package com.SparkleApp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Email {
    @Id
    private Long id;
    private String headTitle;
    private String message;
}
