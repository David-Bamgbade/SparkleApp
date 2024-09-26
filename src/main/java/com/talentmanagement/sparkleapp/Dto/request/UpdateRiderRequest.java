package com.talentmanagement.sparkleapp.Dto.request;

import com.talentmanagement.sparkleapp.data.models.RiderStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateRiderRequest {
    private Long riderId;
    private String RiderStatus;
    private String email;
}
