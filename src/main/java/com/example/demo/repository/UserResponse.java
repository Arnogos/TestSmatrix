package com.example.demo.repository;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Builder
@Accessors(chain = true)
public class UserResponse {
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthday;
    private String gender;
    private String email;
    private Long rub;
    private Integer penny;

}