package service;

import com.example.demo.enity.User;
import com.example.demo.repository.CreateUserRequest;
import com.example.demo.repository.UserResponse;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public interface UserService {

    @NotNull
    List<UserResponse> findAll();

    @NotNull
    User findByLogin(@NotNull String userLogin);

    @NotNull
    UserResponse createUser(@NotNull CreateUserRequest request);

    @NotNull
    UserResponse update(@NotNull Integer userId, @NotNull CreateUserRequest request);

    void delete(@NotNull Integer userId);


}