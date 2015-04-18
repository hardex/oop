package lesson_3;

import figure.Rectangle;

import java.util.Scanner;

/*
* Написать программу, которая будет рисовать на консоли прямоугольник с заданными длинами сторон.
*/

public class Task_4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int height, width;

        System.out.print("Ширина прямоугольника :");
        width = scan.nextInt();
        scan.nextLine();
        System.out.print("Высота прямоугольника :");
        height = scan.nextInt();
        scan.nextLine();

        Rectangle r = new Rectangle(height, width);
        r.print_rec();
    }
}
