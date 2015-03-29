package lesson_1;

/**
 * Created by odogryk on 28.03.2015.
 */
public class remember {
    private static int ins_count = 0;

    public remember () {
        ins_count++;
    }

    public static int remember_count (){
        return ins_count;
    }

}
