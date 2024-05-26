package com.example.demo.service;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class UserResponse {
    private Integer id;
    private Integer login;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthday;
    private Boolean gender;
    private String email;
    private Long rub;
    private Long penny;

}