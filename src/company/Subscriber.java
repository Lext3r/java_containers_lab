package company;

public class Subscriber {

    private String name;
    private String sName;
    private String phone;
    private String plan;
    private int minutes;

    public Subscriber(String name, String sName, String phone, String plan, String minutes){
        this.name = name;
        this.sName = sName;
        this.phone = phone;
        this.plan = plan;
        this.minutes = Integer.valueOf(minutes);
    }

    public static void printOneSub(Subscriber sub){
        if (sub != null){
            System.out.println(sub.getName() + " " + sub.getsName() + " " +
                sub.getPhone() +  " " + sub.getPlan() + " " + sub.getMinutes());
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public String getPlan() {
        return plan;
    }

    public String getPhone() {
        return phone;
    }

    public String getsName() {
        return sName;
    }

    public String getName() {
        return name;
    }
}
