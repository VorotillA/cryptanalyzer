package com.javarush.cryptanalyzer.abzon.structure;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class PathToDesktop {
    public static String getPath(){
        FileSystemView view = FileSystemView.getFileSystemView();
        File file = view.getHomeDirectory();
        return file.getPath();
    }
}
