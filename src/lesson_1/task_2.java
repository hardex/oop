package lesson_1;

/**
 * Created by odogryk on 28.03.2015.
 * Написать класс, который умеет считать количество созданных объектов этого класса (static).
 */

public class task_2 {
    public static void main(String[] args) {
        System.out.println("кол-во экземпляров : "+remember.remember_count());
        for (int i = 0; i < 5; i++) {
            remember r = new remember();
        }
        System.out.println("кол-во экземпляров : "+remember.remember_count());

    }
}
