package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteRiderRequest {
    private String email;
    private String password;
}
