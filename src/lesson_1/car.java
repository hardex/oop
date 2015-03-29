package lesson_1;

/**
 * Created by odogryk on 28.03.2015.
 * Написать класс «автомобиль», который должен уметь заводится, глушить мотор, ехать и держать необходимую скорость.
 */
public class car {

    private boolean started;
    private boolean moving;
    private int speed;

    public car() {
        started = false;
        moving = false;
        speed = 0;
    }

    public boolean isStarted() {
        return started;
    }

    public boolean isMoving() {
        return moving;
    }

    public int getSpeed() {
        return speed;
    }

    public void start () {
        if (!started) started = true;
    }

    public void stop () {
        moving = false;
        started = false;
    }

    public void moving (int speed) {
        if (started) {
            this.speed = speed;
            moving = true;
        }
    }


}
