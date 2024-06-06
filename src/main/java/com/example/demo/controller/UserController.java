package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.enity.User;
import com.example.demo.repository.CreateUserRequestDTO;
import com.example.demo.repository.UserResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/greeting")
    public String greeting(Authentication authentication) {

        String userName = authentication.getName();

        return "Spring Security In-memory Authentication Example - Welcome " + userName;
    }
    private final UserService userService;
    @GetMapping(value = "/{userLogin}", produces = APPLICATION_JSON_VALUE)
    public UserResponse findByLogin(@PathVariable String userLogin) {
        return userService.findByLogin(userLogin);
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse create(@RequestBody CreateUserRequestDTO request) {
        return userService.createUser(request);
    }
    @PostMapping(value = "/{userLogin}/payment", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public User payment(@PathVariable String userLogin, @PathVariable Long userRub, @PathVariable Integer userPenny) {
        return userService.payment(userLogin, userRub, userPenny);
    }
    @PatchMapping(value = "/{userId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse update(@PathVariable Integer userId, @RequestBody CreateUserRequestDTO request) {
        return userService.update(userId, request);
    }
}