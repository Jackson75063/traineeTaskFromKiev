package com.jackson.runner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        BufferedWriter writer =  new BufferedWriter(new FileWriter("./output.json"));

        MenuRunner menuRunner = new MenuRunner();
        menuRunner.start();
    }
}
