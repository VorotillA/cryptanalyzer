package com.javarush.cryptanalyzer.abzon;

import com.javarush.cryptanalyzer.abzon.models.IOText;
import com.javarush.cryptanalyzer.abzon.models.СaesarСipher;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IOText teht = new IOText();
        СaesarСipher chipher = new СaesarСipher(2);
        String textFromFile = teht.readFromFile("C:\\Users\\Администратор\\Desktop\\test");
        textFromFile = chipher.encrypt(textFromFile);
        teht.writeToFile(textFromFile);
        System.out.println("Encypt is over");
    }
}