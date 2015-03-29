package lesson_2.phone;

/**
 * Created by odogryk on 28.03.2015.
 * Написать класс наследник SamsungS4 с диагональю экрана 5 дюймов, поддержкой Wifi и методом отправки
 * SMS, который будет дописывать к сообщению слово “Hello”.
 */
public class SamsungS4 extends Phone {

    public SamsungS4() {
        System.out.println("SamsungS4 constructor");

        touch = true;
        hasWifi = true;
        screenSize = 5;
    }

    @Override
    public void call(String number) {
        call_counts++;
        super.call(number);
        System.out.println("SamsungS4 class is calling " + number);
    }

    @Override
    public void sendSMS(String number, String message) {
        sms_counts++;
        System.out.println("SamsungS4 class is sending sms " + "Hello " + message + " to " + number);
    }
}
