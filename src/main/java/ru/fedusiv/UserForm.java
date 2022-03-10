package ru.fedusiv;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserForm {

    private String email;
    private String password;
    private String username;

}
