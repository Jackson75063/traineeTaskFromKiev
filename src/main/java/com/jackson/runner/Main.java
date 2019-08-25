package com.jackson.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jackson.model.User;
import com.jackson.service.UserService;
import com.jackson.service.UserServiceImpl;
import com.jackson.writter.WriteObjToFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        UserService userService = new UserServiceImpl();
        //  userService.addUser();

        BufferedWriter writer =  new BufferedWriter(new FileWriter("./output.json"));


//        out.writeObject(new User("lolik", "lolik", "lolik", null, null));
//        out.writeObject(new User("lolik123", "lolik123", "lolik123", null, null));



/*
        objectMapper.writeValue(writer, new User("qweqw", "qwe", "qwe", null, null));
*/


        //        objectMapper.clearProblemHandlers();


//        MenuRunner menuRunner = new MenuRunner();
//        menuRunner.start();
    }
}
