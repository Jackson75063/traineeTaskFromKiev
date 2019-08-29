package com.jackson.writter;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jackson.model.User;

import java.io.*;
import java.util.*;

public class FileDriwer {

    private File  file = new File("./test.json");
    private ObjectMapper objectMapper = new ObjectMapper(); // jackson

    private Map<String,User> users = objectMapper.readValue(file, new TypeReference<Map<String, User>>() {
    });


    public void writeToFile(User u)  {
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        try {
            existedFile(file);

            // if file is empty
           /* if(file.length() != 0)
              */

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
        existedFile(file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    //if file is not exist -
    private File existedFile(File f){

        if(!f.exists()) {
            try {
                f.createNewFile();
                f.getParentFile().mkdirs();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(file.length() == 0)
            try {
                new FileWriter(f).write("{ }");
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("CREATED ");

        return f;
    }
}
