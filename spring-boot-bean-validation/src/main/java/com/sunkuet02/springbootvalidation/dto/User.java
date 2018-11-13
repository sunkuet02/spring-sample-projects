package com.sunkuet02.springbootvalidation.dto;

import com.sunkuet02.springbootvalidation.validations.ValidUser;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ValidUser
public class User implements Serializable {

    @NotNull(message = "username should not be null")
    private String username;

    @NotNull(message = "password should not be null")
    private String password;

    private String email;
}