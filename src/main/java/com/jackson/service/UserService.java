package com.jackson.service;

import com.jackson.model.User;

public interface UserService {

    User addUser();
//    User getUserByName(String name);
//    User getUserByPhone(String name);
//    User getUserBySurname(String name);
//    User getUserByRole(String name);
    void deleteByEmail(String email);

}
