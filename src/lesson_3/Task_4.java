package lesson_3;

import java.util.Scanner;

/**
 * Created by odogryk on 04.04.2015.
 * Написать программу, которая будет рисовать на консоли прямоугольник с заданными длинами сторон.
 */
abstract class Figure {
    public abstract int getS();
}

class Rectangle extends Figure {
    private int height, width;

    public Rectangle(int h, int w) {
        height = h;
        width = w;
    }

    public int getS() {
        return height * width;
    }

    public void print_rec () {
        StringBuilder sb = new StringBuilder();
        char ch;

            for (int i = 1; i < height; i++) {

                switch (i) {
                    case 1: {
                        // первая строка
                        for (int j = 1; j < width; j++) {
                            switch (j) {
                                case 1: {
                                    sb.append('┏'); //
                                    break;
                                }
                                default: {
                                    sb.append('━'); // середина первой строки
                                    break;
                                }
                            }
                        }
                        sb.append('┓'); // последний символ первой строки
                        break;
                    }
                    default: {
                        // средние строки
                        for (int j = 1; j < width; j++) {
                            switch (j) {
                                case 1: {

                                    sb.append('│'); //
                                    break;
                                }
                                default: {
                                    sb.append(' '); // середина средней строки
                                    break;
                                }
                            }
                        }
                        sb.append('│'); // последний символ средней строки
                        break;
                    }
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
            // последняя строка
            for (int j = 1; j < width; j++) {
                switch (j) {
                    case 1: {
                        sb.append('┗');
                        break;
                    }
                    default: {
                        sb.append('━'); // середина последней строки
                        break;
                    }
                }
            }
            sb.append('┛'); // последний символ последней строки
            System.out.println(sb.toString());
            sb.setLength(0);

        }
//        ┏┗│━┓┛
//        ▕
    }

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
