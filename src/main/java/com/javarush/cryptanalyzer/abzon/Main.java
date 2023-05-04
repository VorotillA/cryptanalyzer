package com.javarush.cryptanalyzer.abzon;

import com.javarush.cryptanalyzer.abzon.models.СaesarСipher;
import com.javarush.cryptanalyzer.abzon.structure.CryptoAnalyzerAlphabet;

public class Main {
    public static void main(String[] args) {
        СaesarСipher chipher = new СaesarСipher(70);
        System.out.println(chipher.encrypt("тест"));
    }
}