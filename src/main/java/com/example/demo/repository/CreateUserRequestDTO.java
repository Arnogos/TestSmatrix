package com.example.demo.repository;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class CreateUserRequestDTO {
    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthday;

    private String email;
    private String gender;
    private Integer penny;
    private Long rub = 1000L;

}