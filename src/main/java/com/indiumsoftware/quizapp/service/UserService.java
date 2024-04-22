package com.indiumsoftware.quizapp.service;

import com.indiumsoftware.quizapp.dao.UserInfoRepository;
import com.indiumsoftware.quizapp.model.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInformation userInformation) {
        userInformation.setPassword(passwordEncoder.encode(userInformation.getPassword()));
        repository.save(userInformation);
        return "user added to system ";
    }
}
