package com.example.demo.service;

import com.example.demo.enity.User;
import com.example.demo.repository.CreateUserRequestDTO;
import com.example.demo.repository.UserResponse;
import org.antlr.v4.runtime.misc.NotNull;

public interface UserService {


    @NotNull
    UserResponse findByLogin(@NotNull String userLogin);

    @NotNull
    UserResponse createUser(@NotNull CreateUserRequestDTO request);

    @NotNull
    UserResponse update(@NotNull Integer userId, @NotNull CreateUserRequestDTO request);

    User payment(@NotNull String userLogin,Long userRub, Integer userPenny);



}