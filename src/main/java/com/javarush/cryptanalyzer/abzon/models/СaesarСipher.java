package com.javarush.cryptanalyzer.abzon.models;

import com.javarush.cryptanalyzer.abzon.structure.CryptoAnalyzerAlphabet;

public class СaesarСipher {
    private int key = 3;

    public СaesarСipher() {
        this.key = key;
    }

    public String encrypt(String text) {
        String alphabet = CryptoAnalyzerAlphabet.ALPHABET;
        String textFoCript = text;
        String result = "";
        int key = this.key;
        for (int i = 0; i < textFoCript.length(); i++) {
            //получение текущего символа в тексте для шифрования
            char currentSymvol = textFoCript.charAt(i);
            // получение индекса символа с алфавита со здвигом в ключ
            int criptoindex = alphabet.indexOf(currentSymvol) + key;
            // проверка что бы не было выхода за приделы алфавита
            if (criptoindex >= alphabet.length()) {
                // если выход есть смещаемся на начало алфавита
                result += alphabet.charAt(criptoindex - alphabet.length());
            } else {
                //если выхода нет получаем символ со смещением
                result += alphabet.charAt(criptoindex);
            }
        }
        return "";
    }
}
