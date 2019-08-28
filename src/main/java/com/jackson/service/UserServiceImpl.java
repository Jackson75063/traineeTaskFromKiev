package com.jackson.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jackson.model.Roles;
import com.jackson.model.User;
import com.jackson.writter.FileDriwer;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserServiceImpl implements UserService {


    private Scanner sc = new Scanner(System.in);
    private FileDriwer fileDriwer = new FileDriwer();



    public User addUser() {

        User user = new User();
        Set<String> phones = new HashSet<>(3);
        Set<Roles> roles = new HashSet<>(3);


//        List<Roles> role = Arrays.asList(Roles.ADMIN, Roles.GUEST, Roles.THIRD_ROLE);

        System.out.println("Input name: ");
        String parametr = sc.next();
        user.setName(parametr);
        System.out.println("Name : " + user.getName());


        /*
        System.out.println("Input surname: ");
        parametr = sc.next();
        user.setSurname(parametr);
        System.out.println("Surname : " + user.getSurname());*/

        System.out.println("Input Email : ");
        parametr = sc.next();

//        [a-zA-Z_]+@[a-zA-Z_]+?\.[a-zA-Z]{1,3}

        /*if(parametr.equalsIgnoreCase("[a-zA-Z_]+@[a-zA-Z_]+?\\.[a-zA-Z]{1,3}"))
            System.out.println("EEEEEEEEEEEEEEEEEEEe");
        else
            System.out.println("NEEEEEEEEEEEEEEEEE");*/
        user.setEmail(parametr);
        System.out.println("Email : " + user.getEmail());


       /* System.out.println("How much phones roles ?");
        int count = 0;

        try{
            count = sc.nextInt();

            if(count >3)
                System.out.println("Number must be >= 3 ");

            else {
                for (int i = 0; i < count; i++) {
                    System.out.println("Input role #" + (i + 1));
                    parametr = sc.next();
                    if( enumContainsValue(parametr) )
                        roles.add(Roles.valueOf(parametr.toUpperCase()));
                }
                user.setRoles(roles);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        user.setPhones(phones);
        System.out.println("How much phones numbers ?");

        count = 0;
        count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Input number #" + (i+1));
            parametr = sc.next();
            phones.add(parametr);
        }

        user.setPhones(phones);
*/

        System.out.println(user);

        return  user;
    }

    @Override
    public User changeUser(User u) {

        int choise  = 0;
        String parametr;
        System.out.println("What do you want change");
        System.out.println("1. Name");
        System.out.println("2. Surname");
        System.out.println("3. Surname");
        System.out.println("4. Email");
        System.out.println("5. Roles");
        System.out.println("6. Phones");

        switch (choise){

            case 1 :
                System.out.println("input new name");
                parametr = sc.next();
                u.setName(parametr);
                break;

            case 2 :
                System.out.println("input new name");
                parametr = sc.next();
                u.setName(parametr);
                break;

            case 3 :
                System.out.println("input new name");
                parametr = sc.next();
                u.setName(parametr);
                break;

            case 4 :
                System.out.println("input new name");
                parametr = sc.next();
                u.setName(parametr);
                break;

            case 5 :
                System.out.println("input new name");
                parametr = sc.next();
                u.setName(parametr);
                break;

        }
        return u;
    }

    public void deleteByEmail(String mail) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // for good json view

        if(FileDriwer.users.containsKey(mail))
            FileDriwer.users.remove(mail);
        else
            System.out.println("User is not exist.");

    }


    private boolean enumContainsValue(String value){
        for (Roles roles: Roles.values())
            if (roles.name().equalsIgnoreCase(value))
                return true;
        return false;
    }


    public UserServiceImpl() throws IOException {
    }

}
