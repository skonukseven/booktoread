package com.booktoread.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 30)
    @NotNull(message = "Please enter your first name. Min 2 and max 30 char")
    @Column(nullable = false, length = 30)
    private String firstName;

    @Size(min = 2, max = 30)
    @NotNull(message = "Please enter your last name. Min 2 and max 30 char")
    @Column(nullable = false, length = 30)
    private String lastName;

    @Size(min = 4, max = 60, message = "Please enter min 4 characters")
    @NotNull(message = "Please enter your password")
    @Column(nullable = false, length = 120)
    private String password;

    private String resetPasswordCode;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @Size(min = 10, max = 10, message = "Phone number should be exact 10 characters")
    @NotNull(message = "Please enter your phone number")
    @Column(nullable = false, length = 10)
    private String phoneNumber;

    @Email(message = "Please enter valid email")
    @Size(min = 5, max = 80)
    @NotNull(message = "Please enter your email")
    @Column(nullable = false, unique = true, length = 80)
    private String email;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "Please enter your Birth day")
    @Column(nullable = false, length = 150)
    private LocalDate birthDate;

    @Size(min = 10, max = 100)
    @NotNull(message = "Please enter your address")
    @Column(nullable = false, length = 250)
    private String address;

    @Size(max = 15)
    @NotNull(message = "Please enter your zip code")
    @Column(nullable = false, length = 15)
    private String zipCode;


    @NotNull(message = "Score value must be entered.")
    @Column(nullable = false)
    private Integer score = 0;

    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false)
    private Boolean builtIn;


}
