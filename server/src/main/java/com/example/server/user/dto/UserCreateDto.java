package com.example.server.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Pattern(regexp = "^9989[0-9][0-9]{7}$", message = "You can only use Uzbekistan phone number.")
    private String phoneNumber;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}
