package lesson_3;
import java.util.Random;

/**
 * Created by odogryk on 29.03.2015.
 * Создать список разработчиков и заполнить его случайным образом. Вывести на экран только Senior developer-ов с
 * зарплатой больше 1500 у.е.
 */
public class task_2 {
    public static void main(String[] args) {

        Developer[] list = new Developer[10];

        for (int i = 0; i < 10 ; i++) {

            switch (Integer.toString(Math.abs(new Random().nextInt()) %4).charAt(0)) {
                case '0': {
                    list[i] = new JuniorDeveloper("Mike"+i, 500, i*3);
                    break;
                }
                case '1': {
                    list[i] = new TestDeveloper("Vasya"+i, 500, i*3);
                    break;
                }
                case '2': {
                    list[i] = new SeniorDeveloper("Jack"+i, 500, i*3);
                    break;
                }
                case '3': {
                    list[i] = new TeamLeadDeveloper("Robby"+i, 500, i*3);
                    break;
                }
            }
        }

        StringBuilder sb;

        for (Developer d : list) {
            if (d instanceof SeniorDeveloper && d.getSalary() >= 1500 ){
                sb = new StringBuilder() // !!!
                        .append(d.getName())
                        .append(": ")
                        .append(d.getBasicSalary())
                        .append(" -> ")
                        .append(d.getSalary());

                System.out.println(sb.toString());
            }
        }

    }
}
