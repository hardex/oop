package lesson_4.Monitor;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Created by odogryk on 18.04.2015.
 * 3. Добавить в проект «монитор» функцию вывода даты
 создания файла на экран (см. java.io.File).
 */
public class hw_3 {
    public static void main(String[] args) {

        try {
            Monitor m = new Monitor("i:\\1.txt", new FileEvent());
            m.start();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
}
