package com.jackson.writter;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSON;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jackson.model.User;

import java.io.*;
import java.util.*;

public class FileDriwer {

    private File  file = new File("./test.json");
    private ObjectMapper objectMapper = new ObjectMapper(); // jackson

    public static Map users;
    {
        existedFile();
        users = new HashMap<>();
        users = objectMapper.readValue(file, Map.class);
    }



    public void writeToFile(User u)  {
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        try {
            existedFile();

            // if file is empty
            if(file.length() != 0)
                users = objectMapper.readValue(file, Map.class);

//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // for good json view
            users.put(u.getEmail(), u);
            String json = new ObjectMapper().writeValueAsString(users);
            writer.writeValue(file, users);
        } catch (Exception ignored){
        }
    }

    public void rewriteFile(Map<String, User> users){
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(file, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileDriwer() throws IOException {
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Map getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        FileDriwer.users = users;
    }

    //if file is not exist -
    private void existedFile(){

        if(!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("CREATED ");
        }
    }
}
