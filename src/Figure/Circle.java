package figure;

/**
 * Created by odogryk on 28.03.2015.
 */
public class Circle extends Figure {

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

    public float getS () {
        return (float) (radius * radius * Math.PI);
    }

}
