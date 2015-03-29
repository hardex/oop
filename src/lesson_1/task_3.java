package lesson_1;

/**
 * Created by odogryk on 28.03.2015.
 * Написать класс «автомобиль», который должен уметь заводится, глушить мотор, ехать и держать необходимую скорость.
 */
public class task_3 {
    public static void main(String[] args) {

        car c = new car();

        c.moving(60);
        System.out.println("машина едет = " + c.isMoving() + " со скоростью - " + c.getSpeed());

        c.start();
        System.out.println("машина едет = " + c.isMoving() + " со скоростью - " + c.getSpeed());

        c.moving(34);
        System.out.println("машина едет = "+c.isMoving()+" со скоростью - "+c.getSpeed());

    }
}
