package com.watchplant.app.dtos.user;

import com.watchplant.app.dtos.auth.CreateUserAccountRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateUserRequestDTO {

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @NotBlank(message = "O telefone não pode ser vazio")
    @Pattern(regexp = "^([0-9]{6,7})[^0-9]*([0-9]{4})$", message = "O formato do número de telefone é incorreto")
    private String phone;

    @Valid
    private CreateUserAccountRequestDTO account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CreateUserAccountRequestDTO getAccount() {
        return account;
    }

    public void setAccount(CreateUserAccountRequestDTO account) {
        this.account = account;
    }
}
