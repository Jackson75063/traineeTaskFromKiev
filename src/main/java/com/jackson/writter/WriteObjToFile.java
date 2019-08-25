package com.jackson.writter;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jackson.model.User;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteObjToFile {


    private List<User> listOfStudents = new ArrayList<>();
//    PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");

    BufferedWriter writer =  new BufferedWriter(new FileWriter("./output.txt"));


    Path file = Paths.get("the-file-name");

 FileWriter fileWriter = new FileWriter("samplefile2.json");



    public WriteObjToFile() throws IOException {
    }

    public void test(User u){


        ObjectMapper objectMapper = new ObjectMapper(); // jackson
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // for good json view
//        objectMapper.writeValue(writer, new User("lolik123", "lolik123", "lolik123", null, null));


        try {

            objectMapper.writeValue(fileWriter,u );
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        fileWriter.write(fileContent);


    }


    public void writeToFile(User u) {

        ObjectMapper objectMapper = new ObjectMapper(); // jackson
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // for good json view
//        objectMapper.writeValue();
//        Writer writer = new OutputStreamWriter(f);
        try {
            writer.write(u.toString()+"lol");
//            objectMapper.writeValue(writer,u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getListOfStudents () {
        return listOfStudents;
    }

    public void setListOfStudents(List<User> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
}

