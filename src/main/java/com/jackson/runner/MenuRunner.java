package com.jackson.runner;

import com.jackson.model.User;
import com.jackson.service.UserService;
import com.jackson.service.UserServiceImpl;
import com.jackson.writter.FileDriwer;
import java.io.IOException;
import java.util.Scanner;

class MenuRunner {

    private UserService userService = new UserServiceImpl();
    private FileDriwer fileDriwer = new FileDriwer();

    private Scanner sc = new Scanner(System.in);

    void start(){


        int choose;
        String mail;

        boolean isAlive = true;
        while (isAlive){

            System.out.println("PRESS : ");
            System.out.println("1. Add new user");
            System.out.println("2. Edit user by mail");
            System.out.println("3. Delete user by mail");
            System.out.println("4. Print all users");
            System.out.println("9. Close.");
            choose = sc.nextInt();

            switch (choose) {

                case 1:
                    System.out.println("CASE 1");
                    User u = userService.addUser();
                    fileDriwer.writeToFile(u);
                    break;



                case 2:
                    System.out.println("Input user mail for changing ");
                    mail = sc.next();
                    User user = fileDriwer.getUsers().get(mail);
                    User q = userService.changeUser(user);
                    fileDriwer.getUsers().put(q.getEmail(),q);
                    fileDriwer.rewriteFile(fileDriwer.getUsers());

                    System.out.println("CHANGED USER");
                    break;

                case 3:
                    System.out.println("Input mail for deleting : ");
                    mail = sc.next();
                    userService.deleteByEmail(mail,fileDriwer.getUsers());
                    fileDriwer.rewriteFile(fileDriwer.getUsers());
                    break;

                case 4:

                    if (fileDriwer.getUsers().size() == 0) {
                        System.out.println("There is no one user if file. Add users before user.");
                    }

                    fileDriwer.getUsers().forEach((k,v) ->System.out.println(k+" : "+v));
                    break;

                case 9:
                    isAlive = false;
                    break;

                default:
                    System.out.println("WRONG CHOISE !!!");
                    break;
            }
        }
    }


    MenuRunner() throws IOException {
    }



}
