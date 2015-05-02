package lesson_6;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by odogryk on 02.05.2015.
 * 3. ������� 100 �������, ������ �� ������� ������� �� ����� ���� ����� �
 ��������, ���� ��� �������.
 */
public class hw_3 {

    public static class MyThread extends Thread {
        int tNumber;

        public MyThread(int tNumber) {
            super();
            this.tNumber = tNumber;
        }

        @Override
        public void run() {

            System.out.println("Running thread Number : "+ tNumber);
            while ( ! isInterrupted()) { // ������� ���������� ������ �1
                try {
                    Thread.sleep(1000); // ����������������
//                    Thread.yield(); // ��� ���
                } catch (InterruptedException e) {
                    System.out.println("Kill thread Number : "+ tNumber);
                    return; // ������� ���������� ������ �2
                }
            }
            System.out.println("Stop thread Number : "+ tNumber);
        }
    }

    public static void main(String[] args) {

        System.out.println("Generating 100 threads. ");
        MyThread[] mt = new MyThread[100];
        try {
            Thread.sleep(2000); //
            for (int i = 0; i < 100; i++) {
                mt[i] = new MyThread(i);
                mt[i].start(); // ��������� �����
            }
            Thread.sleep(2000); //
            for (int i = 0; i < 100; i++) {
                mt[i].interrupt(); // ��������� �����
            }
        } catch (Exception e) {
            System.out.println("Exception : "+e.getMessage());
        }
    }

}
