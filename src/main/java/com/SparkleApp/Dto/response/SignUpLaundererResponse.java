package com.SparkleApp.Dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SignUpLaundererResponse {
    private String message;
    private LocalDateTime createdAt;

}


