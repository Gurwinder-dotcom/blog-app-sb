package com.BlogPlatform.Blog.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "Username is necessary")
    @Size(min = 3, message = "Username must be greater than three character")
    private String name;
    @NotEmpty
    @Email(message = "Email is not valid")
    private String email;
    @NotEmpty
    @Size(min = 8, message = "Password must have 8 Characters")
    private String password;
    private String about;
}
