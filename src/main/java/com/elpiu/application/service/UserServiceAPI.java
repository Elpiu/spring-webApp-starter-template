package com.elpiu.application.service;

import com.elpiu.application.persistence.entity.User;

public interface UserServiceAPI {

    public boolean emailIsOk(String email);
    public boolean usernameIsOk(String username);
    public User registerUser(User newUser);

}
