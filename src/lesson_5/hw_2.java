package lesson_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by odogryk on 25.04.2015.
 * 2. Ќаписать программу, котора€ считает текстовый файл, заменит в
 нем все слова УHelloФ на У1234Ф и запишет изменени€ в тот-же файл.
 */
public class hw_2 {

    public static void main(String[] args) {
        try {
            RandomAccessFile fin = new RandomAccessFile("i:\\1.txt", "rw");
            byte[] buff = new byte[(int) fin.length()];

            try {
                fin.read(buff);
                String st = new String(buff);
                st = st.replaceAll("Hello", "1234");
                fin.seek(0);
                fin.write(st.getBytes());

//                System.out.println(st);
            } finally {
                fin.close();
            }

        } catch (IOException fe) {
            System.out.println("IOException :" + fe.getMessage());
        }

    }
}
