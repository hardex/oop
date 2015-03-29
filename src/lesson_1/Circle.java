package lesson_1;

/**
 * Created by odogryk on 28.03.2015.
 */
public class Circle {

    public static final String NAME = "Circle";
    private int radius;

    public Circle (){
        radius = 25;
    }

    public Circle (int radius){
        this.radius = radius;
    }

    public int getRadius () {
        return radius;
    }

    public void setRadius (int radius) {
        this.radius = radius;
    }

    public float square () {
        return (float) (radius * Math.PI);
    }

}
