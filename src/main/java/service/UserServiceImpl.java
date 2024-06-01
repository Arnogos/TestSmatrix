package service;

import com.example.demo.enity.User;
import com.example.demo.repository.CreateUserRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::buildUserResponse)
                .collect(Collectors.toList());
    }

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
    public User findByLogin(@NotNull String userLogin) {
        System.out.println(888);
       return userRepository.findByLogin(userLogin);
    }


    @NotNull
    @Override
    @Transactional
    public UserResponse createUser(@NotNull CreateUserRequest request) {
        User user = buildUserRequest(request);
        return buildUserResponse(userRepository.save(user));
    }

    @NotNull
    private User buildUserRequest(@NotNull CreateUserRequest request) {
        return new User()
                .setLogin(request.getLogin())
                .setPassword(request.getPassword())
                .setBirthday(request.getBirthday())
                .setFirstName(request.getFirstName())
                .setMiddleName(request.getMiddleName())
                .setLastName(request.getLastName())
                .setGender(request.getGender())
                .setRub(request.getRub()+1000)
                .setPenny(request.getPenny())
                .setEmail(request.getEmail());
    }


    @Transactional
    public User payment(Long rub1, Integer penny1, String userLogin){

        Optional<User> user = Optional.ofNullable(userRepository.findByLogin(userLogin));
        User user1 = user.get();

        Long rub = user1.getRub();
        Integer penny = user1.getPenny();
        if(rub/10 + penny >= rub1/10 + penny1){
            user1.setRub(rub - rub1);
            user1.setPenny(penny - penny1);
           return userRepository.save(user1);
        } else{
            throw new RuntimeException();
        }
    }

    @NotNull
    @Override
    @Transactional
    public UserResponse update(@NotNull Integer userId, @NotNull CreateUserRequest request) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User " + userId + " is not found"));
        userUpdate(user, request);
        return buildUserResponse(userRepository.save(user));
    }

    private void userUpdate(@NotNull User user, @NotNull CreateUserRequest request) {
        ofNullable(request.getLogin()).ifPresent(user::setLogin);
        ofNullable(request.getFirstName()).ifPresent(user::setFirstName);
        ofNullable(request.getMiddleName()).ifPresent(user::setMiddleName);
        ofNullable(request.getLastName()).ifPresent(user::setLastName);
        ofNullable(request.getBirthday()).ifPresent(user::setBirthday);

    }

    @Override
    @Transactional
    public void delete(@NotNull Integer userId) {
        userRepository.deleteById(userId);
    }




}