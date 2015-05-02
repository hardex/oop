package lesson_6;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by odogryk on 02.05.2015.
 * 2. Создать поток, который будет каждые 10 секунд выводить текущее
 время на экран. Сделать возможность прерывания потока с помощью
 команды с консоли.
 */
public class hw_2 {

    public static class DateOut extends Thread {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss,SS");

        @Override
        public void run() {

            while ( ! isInterrupted()) { // условие завершения потока №1
                System.out.println(sdf.format(System.currentTimeMillis()));
                try {
                    Thread.sleep(10000); // закомментировать
//                    Thread.yield(); // или так
                } catch (InterruptedException e) {
                    return; // условие завершения потока №2
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String k;
        System.out.println("For thread interaption please enter \"y\": ");
        try {
            DateOut dThread = new DateOut();
            dThread.start(); // запускаем поток
            while (scan.hasNext() == false) {Thread.sleep(100);}

            dThread.interrupt(); // прерываем поток
        } catch (Exception e) {
            System.out.println("Exception : "+e.getMessage());
        }
    }

}
