package lesson_3;

/*
5. Построить иерархию классов «Фигуры» с учетом знаний о
        полиморфизме. У каждого класса фигуры должен быть
        метод подсчета площади. Создать список фигур. Вывести
        площади всех фигур на экран.
*/

import figure.Circle;
import figure.Figure;
import figure.Rectangle;

public class task_5 {

    public static void main(String[] args) {

        Figure[] figures = {
                new Circle(23),
                new Rectangle(5, 6)
        };

        System.out.println("Площадь круга = "+ figures[0].getS());
        System.out.println("Площадь прямоугольника = "+ figures[1].getS());

    }
}
