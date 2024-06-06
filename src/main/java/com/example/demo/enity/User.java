package com.example.demo.enity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import jakarta.validation.constraints.Email;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(name = "login")
    private String login;
    @NotBlank
    @Column(name = "password")
    private String password;
    @NotBlank
    @Column(name = "firstName")
    private String firstName;
    @NotBlank
    @Column(name = "middleName")
    private String middleName;
    @NotBlank
    @Column(name = "lastName")
    private String lastName;
    @NotBlank
    @Column(name = "birthday")
    private String birthday;
    @NotBlank
    @Column(name = "gender")
    private String gender;
    @NotBlank
    @Column(name = "email")
    @Email
    private String email;
    @NotBlank
    @Column(name = "rub")
    private Long rub;

    @Column(name = "penny")
    private Integer penny;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "Address.com.example.demo.User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday + '\'' +
                ", email=" + email + '\'' +
                ", rub=" + rub + '\'' +
                ", penny=" + penny + '\'' +
                ", gender=" + gender +
                '}';
    }


}