package lesson_6;

/**
 * Created by odogryk on 02.05.2015.
 * 1. Модифицировать класс Counter так, чтобы он циклически выводил
 числа из определенного диапазона.
 */

public class hw_1 {
    public static class Counter extends Thread {
        private int from, to;

        public Counter (int from, int to) {
            super();
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {

            while ( ! isInterrupted()) { // условие завершения потока №1
                int x = from;
                while (x <= to)
                    System.out.println(x++);
                try {
                    Thread.sleep(500); // закомментировать
//                    Thread.yield(); // или так
                } catch (InterruptedException e) {
                    return; // условие завершения потока №2
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            Counter c = new Counter(5,10);
            c.start(); // запускаем поток
            Thread.sleep(5000); // ждем 5 сек
            c.interrupt(); // прерываем поток
        } catch (Exception e) {
            System.out.println("Exception : "+e.getMessage());
        }
    }

}
