package com.talentmanagement.sparkleapp.Dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class CustomerApiResponse {
    private boolean isSuccessful;
    private Object data;
}
