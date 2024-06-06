package com.example.demo.service;

import com.example.demo.enity.User;
import com.example.demo.repository.CreateUserRequestDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @NonNull
    private UserResponse buildUserResponse(@NotNull User user) {
        return UserResponse.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .birthday(user.getBirthday())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .rub(user.getRub())
                .penny(user.getPenny())
                .email(user.getEmail()).build();
    }

    @NotNull
    @Override
    @Transactional(readOnly = true)
    public UserResponse findByLogin(@NotNull String userLogin) {
       return buildUserResponse(userRepository.findByLogin(userLogin).get());
    }


    @NotNull
    @Override
    @Transactional
    public UserResponse createUser(@NotNull CreateUserRequestDTO request) {
        User user = buildUserRequest(request);
        return buildUserResponse(userRepository.save(user));
    }

    @NotNull
    private User buildUserRequest(@NotNull CreateUserRequestDTO request) {
            return new User()
                    .setLogin(request.getLogin())
                    .setPassword(request.getPassword())
                    .setBirthday(request.getBirthday())
                    .setFirstName(request.getFirstName())
                    .setMiddleName(request.getMiddleName())
                    .setLastName(request.getLastName())
                    .setGender(request.getGender())
                    .setRub(request.getRub())
                    .setPenny(request.getPenny())
                    .setEmail(request.getEmail());
    }


    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User payment(String userLogin, Long userRub, Integer userPenny){

        Optional<User> user = userRepository.findByLogin(userLogin);
        User user1 = user.get();

        Long rub = user1.getRub();
        Integer penny = user1.getPenny();
        if(rub/10 + penny >= userRub/10 + userPenny){
            user1.setRub(rub - userRub);
            user1.setPenny(penny - userPenny);
           return userRepository.save(user1);
        } else{
            throw new RuntimeException();
        }
    }

    @NotNull
    @Override
    @Transactional
    public UserResponse update(@NotNull Integer userId, @NotNull CreateUserRequestDTO request) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User " + userId + " is not found"));
        userUpdate(user, request);
        return buildUserResponse(userRepository.save(user));
    }

    private void userUpdate(@NotNull User user, @NotNull CreateUserRequestDTO request) {
        ofNullable(request.getLogin()).ifPresent(user::setLogin);
        ofNullable(request.getFirstName()).ifPresent(user::setFirstName);
        ofNullable(request.getMiddleName()).ifPresent(user::setMiddleName);
        ofNullable(request.getLastName()).ifPresent(user::setLastName);
        ofNullable(request.getBirthday()).ifPresent(user::setBirthday);

    }





}