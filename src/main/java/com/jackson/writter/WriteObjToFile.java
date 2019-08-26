package com.jackson.writter;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSON;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.jackson.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteObjToFile {

    File  f = new File("./test.json");
    List users = new ArrayList();

    public void writeToFile(User u)  {
        ObjectMapper objectMapper = new ObjectMapper(); // jackson
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        try {
            if(!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
                System.out.println("CREATED ");
            }

            // if file is empty
            if(f.length() != 0)
                users = objectMapper.readValue(f, List.class);

//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // for good json view
            users.add(u);
            writer.writeValue(f, users);

        } catch (Exception ignored){
        }
    }


    public WriteObjToFile() throws IOException {
    }


}
