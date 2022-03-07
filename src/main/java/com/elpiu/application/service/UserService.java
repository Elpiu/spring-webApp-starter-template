package com.elpiu.application.service;


import com.elpiu.application.persistence.entity.User;
import com.elpiu.application.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Controlla se qualcuno è gia registrato con quella email
     * @param email
     * @return
     */
    public boolean emailIsOk(String email){
        return userRepository.existsByEmail(email);
    }

    /**
     * Controlla se l'usurname è gia in uso
     * @param username
     * @return
     */
    public boolean usernameIsOk(String username){
        return userRepository.existsByUsername(username);
    }

    /**
     * Effettua la registrazioen del nuovo utente
     * Username e name vengono settati a stringa vuota
     * @param newUser
     * @return
     */
    public User registerUser(User newUser){
        if(newUser == null) return null;
            newUser.setSurname("");
            newUser.setName("");
            newUser.setJoinedDate(new Date());
            newUser.setRole(User.ROLE_USER);
            newUser.setActive(true);

            User user = userRepository.save(newUser);
            return user;
    }
}
