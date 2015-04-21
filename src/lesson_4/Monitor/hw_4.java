package lesson_4.Monitor;

import java.io.IOException;

/**
 * Created by odogryk on 19.04.2015.
 * 4. Добавить в проект ф-ю мониторинга более одного файла.
 */
public class hw_4 {
    public static void main(String[] args) {

        String[] files = {"i:\\1.txt", "i:\\2.txt", "i:\\3.txt", "i:\\4.txt", "i:\\5.txt"};
        try {
            Monitor m = new Monitor(files, new FileEvent());
            m.start();
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe.getMessage());
        }

    }
}
