package lesson_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * Created by odogryk on 25.04.2015.
 * Написать программу для копирования всех файлов из одного
 каталога в другой.
 */
public class hw_3 {

    public static void copyFile(String src, String dest) throws Exception {
        FileInputStream in = new FileInputStream(src);
        try {
            FileOutputStream out = new FileOutputStream(dest);
            try {
                byte[] buf = new byte[1024]; // 1 KB
                int r;
                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0)
                        out.write(buf, 0, r);
                } while (r > 0);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    static void ReadFiles(String path) {
        File p = new File(path);
//        System.out.println("Directory "+path+" list : ");
        for (String f_name : p.list()) {
            File f = new File(path+"\\"+f_name);
            if (f.isDirectory()) ReadFiles(f.getAbsolutePath());
                    else System.out.println(f.getAbsolutePath());
        }

    }

    private static String src = "i:\\dev2";
    private static String dest = "i:\\dev3";

    public static void main(String[] args) {

        CopyPath(new String());
//        ReadFiles("i:\\dev2");

    }

    private static void CopyPath(String downPath) {
        String absSrc = src+"\\"+downPath;
        String absDest = dest+"\\"+downPath;

        File p = new File(absDest);
        if (!p.exists()) if (!p.mkdir()) return;

        p = new File(absSrc);
        for (String f_name : p.list()) {
            File f = new File(absSrc+"\\"+f_name);
            if (f.isDirectory()) CopyPath(downPath+"\\"+f_name);
            else {
                System.out.println(f.getAbsolutePath());
                try {
                    copyFile(absSrc + "\\" + f_name, absDest + "\\" + f_name);
                } catch (Exception e) {
                    System.out.println("Copy Exception : "+e.getMessage());
                }
            }
        }


    }
}
