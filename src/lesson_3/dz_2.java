package lesson_3;

import java.lang.reflect.Array;

/**
 * Created by odogryk on 16.04.2015.
 * 2. Найти в стандартной библиотеке 5 классов, методы которых
 кидают исключения и написать пример кода для их обработки
 (пример: Integer.parseInt).
 */
public class dz_2 {
    public static void main(String[] args) {

        // 1.
        String st = "45_";
        int i;

        try {
            i = Integer.parseInt(st);
            System.out.println(i);
        } catch (NumberFormatException ne) {
            System.out.println("You have incorrect integer in a String.\n"+ne.getMessage());
        }

        // 2.
        String[] stArray = new String[10];
        try {
            Array.set(stArray, 10, "Go to the Exception!!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You try put value out of Array bounds - " + e.getMessage());
        }

        // 3.
        String st2 = "Hello, my country!";
        try {
            System.out.println(st2.charAt(18));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("You try get value out of String bounds - " + e.getMessage());
        }


    }

}
