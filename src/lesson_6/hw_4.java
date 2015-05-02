package lesson_6;

/**
 * Created by odogryk on 02.05.2015.
 * 4. Создать поток, который создаст 50 потоков, каждый их которых
 * выведет на экран свой номер и дождется, пока его прервут.
 * Прерывание дочерних потоков должно выполнятся из потока их
 * порождающего.
 */
public class hw_4 {

    public static class MyThread extends Thread {
        int tNumber;
        MyThread[] mt;

        public MyThread(int tNumber) {
            super();
            this.tNumber = tNumber;
        }

        @Override
        public void run() {

            System.out.println("Running thread Number : " + tNumber);
            try {
                // Parent Thread
                if (tNumber < 10) {
                    mt = new MyThread[50];
                    for (int i = 0; i < mt.length; i++) {
                        mt[i] = new MyThread((tNumber+1) * 100 + i);
                        mt[i].start(); // запускаем поток
                    }
                }

                while (!isInterrupted())  // условие завершения потока №1
                    try {

                        Thread.sleep(1000); // закомментировать
                    } catch (InterruptedException e) {
                        System.out.println("Kill thread Number : " + tNumber);
                        if (tNumber < 10)
                            for (int i = 0; i < mt.length; i++) {
                                mt[i].interrupt(); // прерываем поток
                            }
                        return; // условие завершения потока №2
                    }
            } catch (Exception e) {
                System.out.println("Thread " + tNumber + ". Exception : " + e.getMessage() + "\n" + e.getStackTrace());
            }
            if (tNumber < 10)
                for (int i = 0; i < mt.length; i++) {
                    mt[i].interrupt(); // прерываем поток
                }
            System.out.println("Stop thread Number : " + tNumber);
        }

    }

    public static void main(String[] args) {
        try {
            Thread.sleep(2000); //
            MyThread m = new MyThread(0);
            m.start(); // запускаем поток
            MyThread m2 = new MyThread(1);
            m2.start(); // запускаем поток
            Thread.sleep(5000); //
            m.interrupt(); // прерываем поток 0
            m2.interrupt(); // прерываем поток 1

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

}
