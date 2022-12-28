package com.bikash.blogapi.binding;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @Size(message = "enter valid name" ,max = 10 ,min = 4)
    private String firstName;
    @NotNull
    @Size(message = "enter valid name" ,max = 10 ,min = 4)
    private String lastName;
    @Email(message = "please enter a valid email")
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Size(message = "enter valid name" ,max = 10 ,min = 4)
    private String aboutUser;
}
