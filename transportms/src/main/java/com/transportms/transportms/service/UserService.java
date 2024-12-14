package com.transportms.transportms.service;

import com.transportms.transportms.model.User;
import com.transportms.transportms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validates user login by checking email and password.
     *
     * @param email    the user's email
     * @param password the user's password
     * @return Optional containing the user if valid, otherwise empty
     */
    public Optional<User> login(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password));
    }
}
