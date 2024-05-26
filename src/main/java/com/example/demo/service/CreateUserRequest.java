package com.example.demo.service;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateUserRequest {
    private Integer id;
    private Integer login;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthday;
    private String email;
    private Boolean gender;
    private Long penny;
    private Long rub;

}