package service;

import Address.CreateAddressRequest;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class CreateUserRequest {
    private Integer id;
    @NotBlank
    private String login;
    private String firstName;
    private String middleName;
    private String lastName;
    private String AgeOfBirth;
    private String email;
    private Boolean Sex;
    private CreateAddressRequest address;

}