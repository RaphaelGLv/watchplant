package com.watchplant.app.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserAccountRequestDTO {
    @NotBlank(message = "O email é um campo obrigatório")
    @Email(message = "O email está em um formato inválido")
    private String email;

    @NotBlank(message = "A senha é um campo obrigatório")
    @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
