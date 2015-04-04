package lesson_3;

import java.util.Random;

/**
 * Created by odogryk on 03.04.2015.
 * Написать код, который разделит список объектов Develope на 3 отдельных списка для Juniors, Seniors и Team Leads.
 * Вывести списки на экран.
 */
public class task_3 {

    private static JuniorDeveloper[] add_item (JuniorDeveloper[] devs){
        JuniorDeveloper[] d = new JuniorDeveloper[devs.length+1];
        for (int i = 0; i < devs.length; i++) {
            d[i] = devs[i];
        }
        return d;
    }
    private static TeamLeadDeveloper[] add_item (TeamLeadDeveloper[] devs){
        TeamLeadDeveloper[] d = new TeamLeadDeveloper[devs.length+1];
        for (int i = 0; i < devs.length; i++) {
            d[i] = devs[i];
        }
        return d;
    }
    private static SeniorDeveloper[] add_item (SeniorDeveloper[] devs){
        SeniorDeveloper[] d = new SeniorDeveloper[devs.length+1];
        for (int i = 0; i < devs.length; i++) {
            d[i] = devs[i];
        }
        return d;
    }

    public static void main(String[] args) {
//        Developer[] list = new Developer[10];
        JuniorDeveloper[] Juniors_list = new JuniorDeveloper[0];
        TeamLeadDeveloper[] Team_Leads_list = new TeamLeadDeveloper[0];
        SeniorDeveloper[] Seniors_list = new SeniorDeveloper[0];

        for (int i = 0; i < 10 ; i++) {

            switch (Integer.toString(Math.abs(new Random().nextInt()) %3).charAt(0)) {
                case '0': {
                    Juniors_list = add_item(Juniors_list);
                    Juniors_list[Juniors_list.length-1] = new JuniorDeveloper("Mike"+i, 500, i*3);
                    break;
                }
                case '1': {
                    Team_Leads_list = add_item(Team_Leads_list);
                    Team_Leads_list[Team_Leads_list.length-1] = new TeamLeadDeveloper("Vasya"+i, 500, i*3);
                    break;
                }
                case '2': {
                    Seniors_list = add_item(Seniors_list);
                    Seniors_list[Seniors_list.length-1] = new SeniorDeveloper("Jack"+i, 500, i*3);
                    break;
                }
            }
        }
        System.out.println("Juniors_list :");
        print_dev_list(Juniors_list);
        System.out.println("Seniors_list :");
        print_dev_list(Seniors_list);
        System.out.println("Team_Leads_list :");
        print_dev_list(Team_Leads_list);
    }

    private static void print_dev_list (Developer[] dev) {
        StringBuilder sb;
        for (Developer d : dev) {
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
