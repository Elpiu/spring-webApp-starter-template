package com.elpiu.application.form.dto;


import javax.validation.constraints.*;

import static com.elpiu.application.form.dto.Regexp.*;


public class RegistrationForm {

    @Email(message = "email non valida ")
    @Size(min=8, max=20)
    @Pattern(regexp = REG_EMAIL)
    private String email;

    private String username;
    private String password;
    private String passwordConfirm;
    private boolean checkedLicense;


}
