package com.example.demo.repository;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateUserRequest {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthday;
    private String email;
    private Boolean gender;
    private Integer penny;
    private Long rub;

}