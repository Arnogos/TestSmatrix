package service;

import Address.AddressResponse;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Builder
@Accessors(chain = true)
public class UserResponse {
    private Integer id;
    private String login;
    private String firstName;
    private String middleName;
    private String lastName;
    private String ageOfBirth;
    private Boolean sex;
    private String email;
    private BigDecimal Balance;
    private AddressResponse address;

}