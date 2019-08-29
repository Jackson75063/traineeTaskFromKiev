package com.jackson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jackson.model.Roles;
import com.jackson.model.User;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {


    private Scanner sc = new Scanner(System.in);

    public User addUser() {

        User user = new User();


//        List<Roles> role = Arrays.asList(Roles.ADMIN, Roles.GUEST, Roles.THIRD_ROLE);

        System.out.println("Input name: ");
        String parametr = sc.next();
        user.setName(parametr);
        System.out.println("Name : " + user.getName());



        System.out.println("Input surname: ");
        parametr = sc.next();
        user.setSurname(parametr);
        System.out.println("Surname : " + user.getSurname());


        do {
            System.out.println("Input Email : ");
            parametr = sc.next();
            System.out.println("Invalid mail.Try again");
        }while (!isEmailValid(parametr));

        user.setEmail(parametr);
        System.out.println("Email : " + user.getEmail());


        System.out.println("How much  roles ?");
        int count = 0;

        writeUserRoles(user);

        writeNumbers(user);

        System.out.println(user);

        return  user;
    }

    @Override
    public User changeUser(User u) {

        int choise;




        boolean run = true;
        while (run) {

            System.out.println("What do you want change");
            System.out.println("1. Name");
            System.out.println("2. Surname");
            System.out.println("3. Email");
            System.out.println("4. Roles");
            System.out.println("5. Phones");
            System.out.println("6. Exit");

            String parametr;
            choise = sc.nextInt();
            switch (choise) {

                case 1:
                    System.out.println("input new name");
                    String name = sc.next();
                    u.setName(name);
                    break;

                case 2:
                    System.out.println("input new surname");
                    parametr = sc.next();
                    u.setSurname(parametr);
                    break;

                case 3:
                    System.out.println("input new email");
                    do {
                        System.out.println("Input Email : ");
                        parametr = sc.next();
                        System.out.println("Invalid mail.Try again");
                    }while (!isEmailValid(parametr));

                    u.setEmail(parametr);
                    break;

                case 4:

                    writeUserRoles(u);

                    break;

                case 5:
                    writeNumbers(u);
                    break;

                case 6:
                    run = false;
                    break;

                default:
                    System.out.println("WRONG CHOISE");
                    break;
            }
        }
        return u;
    }

    public void deleteByEmail(String mail,Map<String,User> users) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // for good json view

        if(users.containsKey(mail))
            users.remove(mail);
        else
            System.out.println("User is not exist.");

    }


    private boolean enumContainsValue(String value){
        for (Roles roles: Roles.values())
            if (roles.name().equalsIgnoreCase(value))
                return true;
        return false;
    }

    //for test task
    private static boolean isNumberValid(String number) {
        Pattern pattern = Pattern.compile("(380)?[0-9]{2}\\s[0-9]{7}");
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }

    //for UA numbers
    private  boolean isNumberValid2(String number) {
        Pattern pattern = Pattern.compile("(380)?[0-9]{9}");
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }

    private boolean isEmailValid(String mail) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)\\.(.+)$");
        Matcher matcher = pattern.matcher(mail);

        return matcher.matches();
    }

    private void writeUserRoles(User u){
        Set<Roles> roles = new HashSet<>(3);
        int count = 0;
        try{
            String parametr;
            count = sc.nextInt();

            if(count > 3 ||count <0)
                System.out.println("Number must be <= 3 ");
            else {
                for (int i = 0; i < count; i++) {
                    System.out.println("Input role #" + (i + 1));
                    parametr = sc.next();
                    if( enumContainsValue(parametr) )
                        roles.add(Roles.valueOf(parametr.toUpperCase()));
                }
                u.setRoles(roles);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void writeNumbers(User u ){

        Set<String> phones = new HashSet<>(3);
        String parametr;

        System.out.println("How much phones numbers ?");
        int  count = 0;
        count = sc.nextInt();
        if(count > 3 ||count <0)
            System.out.println("Number must be <= 3 ");

        for(int i =0; i<count; i++) {
            System.out.println("number #" +(i + 1));
            parametr = sc.next();
            if(isNumberValid2(parametr)){
                phones.add(parametr);
            }else{
                i--;
            }
        }
        u.setPhones(phones);


    }

    public UserServiceImpl() throws IOException {
    }

}
