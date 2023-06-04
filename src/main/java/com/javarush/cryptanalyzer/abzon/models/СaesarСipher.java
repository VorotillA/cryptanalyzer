package com.javarush.cryptanalyzer.abzon.models;

import com.javarush.cryptanalyzer.abzon.structure.CryptoAnalyzerAlphabet;

public class СaesarСipher {
    private int key = 3;

    public СaesarСipher(int key) {
        this.key = key;
    }

    public СaesarСipher() {

    }

    public String encrypt(String textFoCript) {
        String result = "";
        for (int i = 0; i < textFoCript.length(); i++) {
            //получение текущего символа в тексте для шифрования
            char currentSymvol = textFoCript.charAt(i);
            // получение индекса символа с алфавита со здвигом в ключ
            int criptoindex = CryptoAnalyzerAlphabet.ALPHABET.indexOf(currentSymvol) + this.key;
            // проверка что бы не было выхода за приделы алфавита
            if (criptoindex >= CryptoAnalyzerAlphabet.ALPHABET.length()) {
                // если выход есть смещаемся на начало алфавита
                result += CryptoAnalyzerAlphabet.ALPHABET.charAt(criptoindex - CryptoAnalyzerAlphabet.ALPHABET.length());
            } else {
                //если выхода нет получаем символ со смещением
                result += CryptoAnalyzerAlphabet.ALPHABET.charAt(criptoindex);
            }
        }
        return result;
    }

    public String decrypt(String decodingTextFoCript) {
        String result = "";
        for (int i = 0; i < decodingTextFoCript.length(); i++) {
            //получение текущего символа в тексте для шифрования
            char currentSymvol = decodingTextFoCript.charAt(i);
            // получение индекса символа с алфавита с обратным здвигом в ключ
            int criptoindex = CryptoAnalyzerAlphabet.ALPHABET.indexOf(currentSymvol) - this.key;
            // проверка что бы не было выхода за приделы алфавита
            if (criptoindex < 0) {
                // если выход есть смещаемся на начало алфавита
                result += CryptoAnalyzerAlphabet.ALPHABET.charAt(criptoindex + CryptoAnalyzerAlphabet.ALPHABET.length());
            } else {
                //если выхода нет получаем символ со смещением
                result += CryptoAnalyzerAlphabet.ALPHABET.charAt(criptoindex);
            }
        }
        return result;
    }

    public int getKey() {
        return this.key;
    }

    public String bruteForce(String text) {
        String result = "";
        String endl = System.getProperty("line.separator");
        for (int i = 1; i <= CryptoAnalyzerAlphabet.ALPHABET.length(); i++) {
            this.key = i;
            result += (" key " + i + " " + this.decrypt(text) + endl);
        }
        this.key = 3;
        return result;

    }
}
