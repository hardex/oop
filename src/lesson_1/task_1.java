package lesson_1;

import figure.Circle;

/**
 * Created by odogryk on 28.03.2015.
 * Написать класс Circle (круг) по аналогии с Rectangle и метод, который будет возвращать его площадь.
 */
public class task_1 {
    public static void main(String[] args) {

        Circle c = new Circle(45);
        System.out.println("Radius : "+c.getRadius());
        System.out.println("Square : "+c.getS());
    }
}
