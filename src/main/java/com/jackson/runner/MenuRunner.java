package com.jackson.runner;

import com.jackson.model.User;
import com.jackson.service.UserService;
import com.jackson.service.UserServiceImpl;
import com.jackson.writter.WriteObjToFile;

import java.io.*;
import java.util.Scanner;

public class MenuRunner {

    private final FileOutputStream file = new FileOutputStream("D:\\staff.json");

    private boolean isAlive = true;

    private UserService userService = new UserServiceImpl();

    private WriteObjToFile writeObjToFile = new WriteObjToFile();

    public MenuRunner() throws IOException {
    }

    public void start(){

        int choose =0;

        while (isAlive){

            System.out.println("PRESS : ");
            System.out.println("1. Add new user");
            System.out.println("2. Find user by name");
            System.out.println("3. Edit user by name");
            System.out.println("4. Delete user by name");
            System.out.println("5. Delete user by name");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();

            switch (choose) {

                case 1:
                    System.out.println("CASE 1");
                    User u = userService.addUser();
                    writeObjToFile.writeToFile(u);
//                    writeObjToFile.test(u);
                    break;
                case 2:
                    System.out.println("CASE 2");
                    break;

                default:
                    System.out.println("WRONG CHOISE !!!");
                    break;
            }
        }
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
