package lesson_4.Monitor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by odogryk on 21.04.2015.
 * Написать код для мониторинга каталога. Выводить на экран предупреждение если в каталог добавляется текстовый
 файл (*.txt).
 */
public class hw_5 {

    public static void main(String[] args) {

        try {
            MonitorPath m = new MonitorPath("i:\\", ".txt", new FileEvent());
            m.start();
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe.getMessage());
        }


    }

}
