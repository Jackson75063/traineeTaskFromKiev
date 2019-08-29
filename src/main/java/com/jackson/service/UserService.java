package com.jackson.service;

import com.jackson.model.User;

import java.util.Map;

public interface UserService {

    User addUser();
    User changeUser(User u);
    void deleteByEmail(String mail, Map<String,User> list);

}
