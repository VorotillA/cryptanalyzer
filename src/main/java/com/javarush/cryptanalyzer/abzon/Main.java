package com.javarush.cryptanalyzer.abzon;

import com.javarush.cryptanalyzer.abzon.models.СaesarСipher;
import com.javarush.cryptanalyzer.abzon.structure.CryptoAnalyzerAlphabet;

public class Main {
    public static void main(String[] args) {
        СaesarСipher chipher = new СaesarСipher(70);
       String t = chipher.encrypt("тест");

        System.out.println(t);
        System.out.println(chipher.decodingEncrypt(t));
    }
}