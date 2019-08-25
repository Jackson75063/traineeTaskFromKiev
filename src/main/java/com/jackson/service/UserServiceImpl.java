package com.jackson.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.model.Roles;
import com.jackson.model.User;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserServiceImpl implements UserService {


    Scanner sc = new Scanner(System.in);

    public User addUser() {

        User user = new User();
        Set<String> phones = new HashSet<>(3);
        Set<Roles> roles = new HashSet<>(3);
/*

//        List<Roles> role = Arrays.asList(Roles.ADMIN, Roles.GUEST, Roles.THIRD_ROLE);

        System.out.println("Input name: ");
        String parametr = sc.next();
        user.setName(parametr);
        System.out.println("Name : " + user.getName());

        System.out.println("Input surname: ");
        parametr = sc.next();
        user.setSurname(parametr);
        System.out.println("Surname : " + user.getSurname());*/

        System.out.println("Input Email : ");
        String parametr = sc.next();

//        [a-zA-Z_]+@[a-zA-Z_]+?\.[a-zA-Z]{1,3}

        if(parametr.equalsIgnoreCase("[a-zA-Z_]+@[a-zA-Z_]+?\\.[a-zA-Z]{1,3}"))
            System.out.println("EEEEEEEEEEEEEEEEEEEe");
        else
            System.out.println("NEEEEEEEEEEEEEEEEE");
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

    public void deleteByEmail(String email) {

    }

    private boolean enumContainsValue(String value){
        for (Roles roles: Roles.values())
            if (roles.name().equalsIgnoreCase(value))
                return true;
        return false;
    }

}
