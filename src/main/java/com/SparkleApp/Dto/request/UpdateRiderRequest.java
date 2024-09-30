package com.SparkleApp.Dto.request;

import com.SparkleApp.data.models.RiderStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateRiderRequest {
    private Long riderId;
    private RiderStatus riderStatus;
    private String email;

}
