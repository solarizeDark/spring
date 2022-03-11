package ru.fedusiv.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpForm {

    private String email;
    private String password;
    private String username;

}
