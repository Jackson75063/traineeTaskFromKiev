package com.jackson.service;

import com.jackson.model.User;

public interface UserService {

    User addUser();
    //    User getUserByName(String name);
//    User getUserByPhone(String name);
//    User getUserBySurname(String name);
//    User getUserByRole(String name);
    User changeUser(User u);
    void deleteByEmail(String mail);

}
