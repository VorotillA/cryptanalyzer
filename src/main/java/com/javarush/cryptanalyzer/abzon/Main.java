package com.javarush.cryptanalyzer.abzon;

import com.javarush.cryptanalyzer.abzon.models.IOText;
import com.javarush.cryptanalyzer.abzon.models.СaesarСipher;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("1 - скажу привет");
        System.out.println("2 - пошлю в жопу");
        System.out.println("3 - скажу что ты тупой");
        System.out.println("0 - выход");
        Scanner scaner = new Scanner(System.in);
        int action = scaner.nextInt();
        while(action != 0){
            switch(action){
                case 1:
                    System.out.println("Привет");
                    //тут можно влепить любую логику
                    action = scaner.nextInt();
                    break;
                case 2:
                    System.out.println("Пошел в жопу");
                    action = scaner.nextInt();
                    break;
                case 3:
                    System.out.println("ты тупой");
                    action = scaner.nextInt();
                    break;
                default:
                    System.out.println("Дибил нет такого пункта в меню");
                    action = scaner.nextInt();
                    break;
            }
        }
//        IOText teht = new IOText();
//        СaesarСipher chipher = new СaesarСipher(2);
//        String textFromFile = teht.readFromFile("C:\\Users\\Администратор\\Desktop\\test");
//        textFromFile = chipher.encrypt(textFromFile);
//        teht.writeToFile(textFromFile);
//        System.out.println("Encypt is over");
    }
}