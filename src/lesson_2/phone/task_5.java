package lesson_2.phone;

/**
 * Created by odogryk on 28.03.2015.
 * Написать код для связи телефонов между собой. У каждого телефона будет свой номер. При вызове
 * call(x) телефон должен найти собеседника по номеру x из всех доступных в данный момент
 * телефонов )из всех созданных объектов типа Phone) и вызвать его метод answer().
 */
public class task_5 {
    public static void main(String[] args) {

//        Nokia3310[] plist = new Nokia3310[10];

        for (int i = 0; i < 10; i++) {
            new Nokia3310("234-56-0"+i);
            System.out.println("Nokia3310 number: " + Phone.plist[i].getNumber());
        }

        Phone.plist[3].call("234-56-00");
        Phone.plist[6].call("234-56-01");
/*
        Nokia3310 nokia = new Nokia3310("345-67-89");
        nokia.call("123-45-67");
        System.out.println("Nokia3310 number: " + nokia.getNumber());
*/

        System.out.println("----------------------------------");

    }
}
