package lesson_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by odogryk on 26.04.2015.
 * 4. Написать программу, которая создаст текстовый файл и запишет в
 него список файлов (путь, имя, дата создания) из заданного
 каталога.
 */
public class hw_4 {

    static ArrayList<String> list = new ArrayList<String>();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss,SS");


    static void ReadFiles(String path) {
        File p = new File(path);
        for (String f_name : p.list()) {
            File f = new File(path+"\\"+f_name);
            if (f.isDirectory()) ReadFiles(f.getAbsolutePath());
            else try {
                BasicFileAttributes fAtr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
                list.add("File : "+f.getAbsolutePath() + ", created : "+ sdf.format(fAtr.creationTime().toMillis()) + "\n");
            } catch (IOException ioe) {
                System.out.println("IOException : " + ioe.getMessage());
            }
        }

    }

    public static void main(String[] args) {

        ReadFiles("i:\\dev2");
        try {
            FileOutputStream out = new FileOutputStream("i:\\dir_list.txt");
            try {
                for (String l : list)
                    out.write(l.getBytes());
            } finally {
                out.close();
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }


    }

}
