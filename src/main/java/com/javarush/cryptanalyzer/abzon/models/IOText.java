package com.javarush.cryptanalyzer.abzon.models;

import com.javarush.cryptanalyzer.abzon.structure.PathToDesktop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class IOText {
    private final String fileName = "\\Output_%s.txt";

    public void writeToFile(String outputString) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(PathToDesktop.getPath() + this.getFileName());
        fileOutputStream.write(outputString.getBytes());
        fileOutputStream.close();
    }

    private String getFileName() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return String.format(this.fileName, dateTime.format(date));
    }

    public String readFromFile(String pathToFile) throws IOException {
        File file = new File(pathToFile + ".txt");
        Scanner scanner = new Scanner(file);
        String result = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result += line;
        }
        scanner.close();
        return result;
    }
}
