package com.javarush.cryptanalyzer.abzon;
import com.javarush.cryptanalyzer.abzon.models.MyMenu;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyMenu menu = new MyMenu();
        menu.mainMenu();
    }
}