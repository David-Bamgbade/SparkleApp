package com.SparkleApp.Dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupCustomerRequest implements CharSequence {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
