package com.example.demo.service;

import com.example.demo.User.User;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public interface UserService {

    @NotNull
    List<UserResponse> findAll();

    @NotNull
    User findByLogin(@NotNull Integer userLogin);

    @NotNull
    UserResponse createUser(@NotNull CreateUserRequest request);

    @NotNull
    UserResponse update(@NotNull Integer userId, @NotNull CreateUserRequest request);

    void delete(@NotNull Integer userId);


}