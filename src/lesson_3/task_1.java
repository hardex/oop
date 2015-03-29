package lesson_3;

/**
 * Created by odogryk on 29.03.2015.
 * Написать своего наследника Developer. Добавить его в существующий проект.
 */
public class task_1 {
    public static void main(String[] args) {
        Developer[] list = {
                new JuniorDeveloper("Mike", 500, 0),
                new JuniorDeveloper("Dima", 500, 1),
                new TestDeveloper("Vasya", 500, 2),
                new SeniorDeveloper("Jack", 500, 5),
                new TeamLeadDeveloper("Robby", 500, 7)
        };
        StringBuilder sb;

        for (Developer d : list) {
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
