package lesson_2.phone;

public abstract class Phone {
	
	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;
    protected int call_counts;
    protected String number;
    protected int sms_counts;
    protected static Phone[] plist = new Phone[10];
    protected int pos;

    private void add_item (){
        Phone[] p = new Phone[plist.length*2];
        for (int i = 0; i < plist.length; i++) {
            p[i] = plist[i];
        }
        plist = p;
    }

    private int next_item (){
        for (int i = 0; i < plist.length; i++) {
            if (plist[i] == null) return i;
        }
        int next = plist.length;
        add_item();

        return next;
    }

    public Phone() {
        System.out.println("Phone constructor");
    }

    public Phone(String number) {
        this.setNumber(number);
        plist[next_item()] = this;
//        System.out.println("Phone constructor, number is " + this.number);
    }

    public int getCall_counts() {
        return call_counts;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

	public boolean isTouch() {
		return touch;
	}
	
	public boolean isHasWifi() {
		return hasWifi;
	}
	
	public int getScreenSize() {
		return screenSize;
	}

    public void answer (String number) {
        System.out.println("Phone class is answer " + number);
    }

    public void call(String number) {

        System.out.println("Phone class is calling " + number);
        for (int i = 0; i < plist.length; i++) {
            if (plist[i].getNumber().equalsIgnoreCase(number)) {
                plist[i].answer(this.number);
            }
        }
    }

	public abstract void sendSMS(String number, String message);

    public int getSms_counts() {
        return sms_counts;
    }

}
