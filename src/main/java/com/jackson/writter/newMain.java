/*
package com.jackson.writter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.jackson.model.User;

import javax.management.relation.Role;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class newMain {

    static List list = new ArrayList();
    synchronized static void user_info(int user_num) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= user_num; i++) {

            System.out.println("Пользователь "+ i);
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите фамилию: ");
            String surname = scanner.nextLine();

            System.out.print("Введите почту: ");
            String email = scanner.nextLine();

            //Проверка почты
            for (int k = 0; k <= email.length(); k++) {
                if (email.contains("@") && email.contains(".")) {
                    continue;
                } else {
                    System.out.println("Неверная почта!");
                    System.out.print("Введите почту: ");
                    email = scanner.nextLine();
                }
            }

            System.out.print("Введите роль: ");
            String role = scanner.nextLine();

            //TODO: Добавить возможность добавления еще одной роли
//        System.out.println("Еще роль?");
//        String subrole = scanner.nextLine();
//        if(!subrole.isEmpty()) {
//            user.setRole(Role.valueOf(subrole.toUpperCase()));
//        }

            System.out.print("Введите телефон: ");
            String cellphone = scanner.nextLine();
            System.out.println();


            //Проверка номера
            for (int j = 0; j <= cellphone.length(); j++) {
                if (cellphone != null || cellphone.substring(0, 3).equals("380") && cellphone.length() == 12) {
                    continue;
                } else {
                    System.out.print("Введен неправильный номер!");
                    System.out.print("Введите телефон: ");
                    cellphone = scanner.nextLine();
                }
            }
            setUser(name, surname, email, role, cellphone);
        }
    }

  */
/*  private static void setUser(String name, String surname, String email, String role, String cellphone) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
//        user.setRole(Role.valueOf(role.toUpperCase()));
//        user.setPhones(cellphone);
        list.add(user);
        addFile(list, user);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько будет пользователей? ");
        int user_num = scanner.nextInt();
        user_info(user_num);
    }
*//*


   */
/* public static void addFile(List list, User...user) {
        try {
            FileOutputStream os = new FileOutputStream("file.json", true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            list.add(user);
            String temp = gson.toJson(user);

            bw.append(user.toString());
            bw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }*//*


//    }

    */
/*public static void readFile(String email){

        try {
            JsonReader reader = new JsonReader(new FileReader("file.json"));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            User[] data = gson.fromJson(reader, User[].class);
            String user1 = gson.toJson(data);
            System.out.println(user1);

//            //Map<String,String> items = new HashMap<>();
//            JSONObject jsonObject = new JSONObject(user1);
//            JSONObject obj = jsonObject.getJSONObject(email);
//            System.out.println(obj);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
*//*


}
*/
