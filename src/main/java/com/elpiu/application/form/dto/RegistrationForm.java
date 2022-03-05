package com.elpiu.application.form.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

import static com.elpiu.application.form.dto.Regexp.*;



@Getter
@Setter
@ToString
@Data
public class RegistrationForm {

    @Email(message = "email non valida ")
    @Pattern(regexp = REG_EMAIL, message = REG_NAME_SURNAME_MESSAGE)
    private String email;

    @Pattern(regexp = REG_USERNAME, message = REG_USERNAME_MESSAGE)
    private String username;

    @Pattern(regexp = REG_PASSWORD, message = REG_PASSWORD_MESSAGE)
    private String password;

    @Pattern(regexp = REG_PASSWORD, message = REG_PASSWORD_MESSAGE)
    private String passwordConfirm;

    @AssertTrue(message = "Condizioni non accettate")
    private boolean checkedLicense;


}
