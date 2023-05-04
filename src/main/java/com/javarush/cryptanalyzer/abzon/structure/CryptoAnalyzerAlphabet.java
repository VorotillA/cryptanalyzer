package com.javarush.cryptanalyzer.abzon.structure;

import java.lang.reflect.Array;

public class CryptoAnalyzerAlphabet {
    private static final String upperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЬЭЮЯ";
    private static final String lowerCase = "абвгдеёжзийклмнопрстуфхцчшщыьэюя";
    private static final String numbers = "013456789";
    private static final String symbols = ".,\\\":-!? ";
    public static final String ALPHABET = (upperCase + lowerCase + numbers + symbols);
}
