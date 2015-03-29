package lesson_2.phone;

public class IPhone extends Phone {
	
	public IPhone() {
		System.out.println("IPhone constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}
	
	@Override
	final public void call(String number) {
        call_counts++;
        System.out.println("IPhone class is calling " + number);
	}
	
	@Override
	public void sendSMS(String number, String message) {
        sms_counts++;
		System.out.println("IPhone class is sending sms " + message + " to " + number);
	}
}
