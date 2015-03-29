package lesson_2.phone;

public class Nokia3310 extends Phone {

    private void initNokia3310() {
        touch = false;
        hasWifi = false;
        screenSize = 2;
    }

    public Nokia3310(String number) {
        super(number);
        initNokia3310();
    }

	public Nokia3310() {
//		System.out.println("Nokia3310 constructor");
        initNokia3310();
	}
	
	@Override
	public void call(String number) {
        call_counts++;
		super.call(number);
//		System.out.println("Nokia3310 class is calling " + number);
	}
	
	@Override
	public void sendSMS(String number, String message) {
        sms_counts++;
        System.out.println("Nokia3310 class is sending sms " + message + " to " + number);
	}
}
