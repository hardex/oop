package lesson_2.phone;

/**
 * Created by odogryk on 28.03.2015.
 * Написать класс наследник SamsungS4 с диагональю экрана 5 дюймов, поддержкой Wifi и методом отправки
 * SMS, который будет дописывать к сообщению слово “Hello”.
 */
public class task_1 {
    public static void main(String[] args) {

        SamsungS4 samsungS4 = new SamsungS4();
        System.out.println("SamsungS4 screen size: " + samsungS4.getScreenSize());
        samsungS4.call("123-45-67");
        samsungS4.sendSMS("567-78-89", "text message");

    }
}
