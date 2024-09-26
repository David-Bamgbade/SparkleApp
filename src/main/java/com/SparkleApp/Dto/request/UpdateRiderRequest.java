package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateRiderRequest {
    private Long riderId;
    private String RiderStatus;
    private String email;

}
