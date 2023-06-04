package com.javarush.cryptanalyzer.abzon.models;

import java.io.IOException;
import java.util.Scanner;

public class MyMenu {
    private final String INPUT_FILE = "input_file";
    private final String INPUT_CONSOLE = "input_console";
    private final String OUTPUT_FILE = "output_file";
    private final String OUTPUT_CONSOLE = "output_console";
    private final Scanner SCANER;
    private final String ACTION_ENCRYPT = "action_encrypt";
    private final String ACTION_DECRYPT = "action_decrypt";
    private final String ACTION_BRUTE_FORCE = "Brute force";
    private String selectedInput;
    private String selectedOutput;
    private String selectedAction;
    private int currentKey = 0;

    public MyMenu() {
        this.SCANER = new Scanner(System.in);
    }

    public void mainMenu() throws IOException {
        this.greetingsMainMenu();
        int action = SCANER.nextInt();
        while (action != 0) {
            switch (action) {
                case 1 -> {
                    this.selectedAction = this.ACTION_ENCRYPT;
                    this.inputMenu();
                    this.greetingsMainMenu();
                    action = SCANER.nextInt();
                }
                case 2 -> {
                    this.selectedAction = this.ACTION_DECRYPT;
                    this.inputMenu();
                    this.greetingsMainMenu();
                    action = SCANER.nextInt();
                }
                case 3 -> {
                    СaesarСipher chip = new СaesarСipher();
                    String text = "Привет мир";
                    System.out.println("Пример текста: " + text);
                    System.out.println("Дэфолтный ключ: " + chip.getKey());
                    System.out.println("Зашифрованый текст: " + chip.encrypt(text));
                    this.greetingsMainMenu();
                    action = SCANER.nextInt();
                }
                case 4 -> {
                    this.selectedAction = this.ACTION_BRUTE_FORCE;
                    this.inputMenu();
                    this.greetingsMainMenu();
                    action = SCANER.nextInt();
                }
                default -> {
                    System.out.println("Нет такого пункта в меню");
                    System.out.println("Повторите ввод от 0 до 4 !!!");
                    action = SCANER.nextInt();
                }
            }
        }
        System.out.println("Спасибо за использоваие программы!!!");
        System.out.println("До встречи");
    }

    private void greetingsMainMenu() {
        System.out.println("Привет, выбери действие:");
        System.out.println("1 - зашифровать");
        System.out.println("2 - разшифровать");
        System.out.println("3 - пример шифрования");
        System.out.println("4 - Брутфорс Цезаря");
        System.out.println("0 - выход");
    }

    private void inputMenu() throws IOException {
        this.greetingsInputMenu();
        int action = SCANER.nextInt();
        while (action != 0) {
            switch (action) {
                case 1 -> {
                    this.selectedInput = this.INPUT_CONSOLE;
                    this.outputMenu();
                    this.greetingsInputMenu();
                    action = SCANER.nextInt();
                }
                case 2 -> {
                    this.selectedInput = this.INPUT_FILE;
                    this.outputMenu();
                    this.greetingsInputMenu();
                    action = SCANER.nextInt();
                }
                default -> {
                    System.out.println("Нет такого пункта в меню");
                    System.out.println("Повторите ввод от 0 до 2 !!!");
                    action = SCANER.nextInt();
                }
            }
        }
    }

    private void greetingsInputMenu() {
        System.out.println("Выбери источник:");
        System.out.println("1 - из консоли");
        System.out.println("2 - из текстового документа");
        System.out.println("0 - назад");
    }

    private void outputMenu() throws IOException {
        this.greetingsOutputMenu();
        int action = SCANER.nextInt();
        while (action != 0) {
            switch (action) {
                case 1 -> {
                    this.selectedOutput = this.OUTPUT_CONSOLE;
                    if (this.selectedAction.equals(this.ACTION_BRUTE_FORCE)) {
                        this.action();
                        this.mainMenu();
                    } else {
                        this.inputKeyMenu();
                        this.greetingsOutputMenu();
                        action = SCANER.nextInt();
                    }
                }
                case 2 -> {
                    this.selectedOutput = this.OUTPUT_FILE;
                    if (this.selectedAction.equals(this.ACTION_BRUTE_FORCE)) {
                        this.action();
                        this.mainMenu();
                    } else {
                        this.inputKeyMenu();
                        this.greetingsOutputMenu();
                        action = SCANER.nextInt();
                    }
                }
                default -> {
                    System.out.println("Нет такого пункта в меню");
                    System.out.println("Повторите ввод от 0 до 2 !!!");
                    action = SCANER.nextInt();
                }
            }
        }
    }

    private void greetingsOutputMenu() {
        System.out.println("Выбери способ вывода:");
        System.out.println("1 - вывод на консоль");
        System.out.println("2 - вывод текстовый документ");
        System.out.println("0 - назад");
    }

    private void inputKeyMenu() throws IOException {
        this.greetingsInputKeyMenu();
        int action = SCANER.nextInt();
        while (action != 0) {
            switch (action) {
                case 1 -> {
                    System.out.println("Ввелите новый ключ!");
                    this.currentKey = SCANER.nextInt();
                    this.action();
                    this.mainMenu();
                }
                case 2 -> {
                    this.currentKey = 0;
                    this.action();
                    this.mainMenu();
                }
                default -> {
                    System.out.println("Нет такого пункта в меню");
                    System.out.println("Повторите ввод от 0 до 2 !!!");
                    action = SCANER.nextInt();
                }
            }
        }
    }

    private void greetingsInputKeyMenu() {
        System.out.println("Вы хотите изменить ключ?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        System.out.println("0 - назад");
    }

    private void action() throws IOException {
        IOText ioText = new IOText();
        СaesarСipher cipher = this.currentKey == 0 ? new СaesarСipher() : new СaesarСipher(this.currentKey);
        String result = "";
        String text = "";
        if (this.selectedInput.equals(this.INPUT_CONSOLE)) {
            System.out.println("Введите текс:");
            SCANER.nextLine();
            text = SCANER.nextLine();
        } else {
            System.out.println("Введите путь к файлу без .txt");
            SCANER.nextLine();
            String path = SCANER.nextLine();
            text = ioText.readFromFile(path);
        }
        if (this.selectedAction.equals(this.ACTION_ENCRYPT)) {
            result = cipher.encrypt(text);
        } else if (this.selectedAction.equals(this.ACTION_BRUTE_FORCE)) {
            result = cipher.bruteForce(text);
        } else {
            result = cipher.decrypt(text);
        }
        if (this.selectedOutput.equals(this.OUTPUT_CONSOLE)) {
            System.out.println(result);
        } else {
            ioText.writeToFile(result);
        }
        System.out.println("ПАМ ПАРА ПАМ ((( ЗАВЕРШЕНО )))");
    }
}
