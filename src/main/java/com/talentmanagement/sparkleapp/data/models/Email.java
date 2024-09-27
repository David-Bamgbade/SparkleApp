package com.talentmanagement.sparkleapp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Entity
public class Email {
    @Id
    private Long id;
    private String headTitle;
    private String message;

}
