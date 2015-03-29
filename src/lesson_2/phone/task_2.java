package lesson_2.phone;

/**
 * Created by odogryk on 28.03.2015.
 * Модифицировать класс Phone так, чтобы он считал количество звонков и сообщений отдельно для каждого объекта.
 */
public class task_2 {

    public static void main(String[] args) {

        Nokia3310 nokia = new Nokia3310();
        nokia.call("123-45-67");
        nokia.call("345-32-45");
        nokia.sendSMS("567-78-89", "text message");
        System.out.println("Nokia3310 calls count: " + nokia.getCall_counts());
        System.out.println("Nokia3310 SMS count: " + nokia.getSms_counts());

        System.out.println("----------------------------------");

        IPhone5 iphone5 = new IPhone5();
        iphone5.sendSMS("567-78-89", "text message");
        System.out.println("IPhone5 calls count: " + iphone5.getCall_counts());
        System.out.println("IPhone5 SMS count: " + iphone5.getSms_counts());

        System.out.println("----------------------------------");

        IPhone iphone = new IPhone();
        iphone.call("123-45-67");
        iphone.sendSMS("567-78-89", "text message");
        iphone.sendSMS("337-22-11", "text message");
        System.out.println("IPhone calls count: " + iphone.getCall_counts());
        System.out.println("IPhone SMS count: " + iphone.getSms_counts());

    }
}
