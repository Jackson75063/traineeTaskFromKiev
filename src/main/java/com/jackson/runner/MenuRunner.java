package com.jackson.runner;

import com.jackson.model.User;
import com.jackson.service.UserService;
import com.jackson.service.UserServiceImpl;
import com.jackson.writter.FileDriwer;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class MenuRunner {

    private boolean isAlive = true;

    private UserService userService = new UserServiceImpl();

    private FileDriwer fileDriwer = new FileDriwer();

    public MenuRunner() throws IOException {
    }

    public void start(){

        int choose = 0;

        while (isAlive){

            System.out.println("PRESS : ");
            System.out.println("1. Add new user");
            System.out.println("2. Find user by name");
            System.out.println("3. Edit user by name");
            System.out.println("4. Delete user by mail");
            System.out.println("5. Print all users");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();

            switch (choose) {

                case 1:
                    System.out.println("CASE 1");
                    User u = userService.addUser();
                    fileDriwer.writeToFile(u);
//                    fileDriwer.test(u);
                    break;
                case 2:
                    System.out.println("CASE 2");
                    break;

                case 4:
                    System.out.println("Input mail for deleting : ");
                    String mail = sc.next();
                    userService.deleteByEmail(mail);
                    System.out.println("DELETED");
                    fileDriwer.rewriteFile(FileDriwer.users);
                    System.out.println("REWRITED");

                    break;

                case 5:


                    if (FileDriwer.users.size() == 0) {
                        System.out.println("OOPSSSSS");
                    }

                    FileDriwer.users.forEach((k,v) ->System.out.println(k+" : "+v));
                    System.out.println("PRINTED");
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
