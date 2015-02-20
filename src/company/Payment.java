package company;

import java.util.List;
import java.util.Scanner;

public class Payment {
    public static Scanner sc = new Scanner(System.in);

    public static Subscriber chooseSubscriber(List<Subscriber> list){
        Subscriber s;
        System.out.println("List of subscribers:");
        SubList.printSubs(list);
        System.out.println("Choose number of the subscriber");
        try {
            s = list.get(Integer.valueOf(sc.next())-1);
        } catch (Exception e){
            System.out.println("Wrong Input. Try again.");
            return chooseSubscriber(list);
        }
        return s;
    }

    public static double getPayment(Subscriber s){
        if (s.getPlan().compareTo("Unlimited") == 0)
            return 420;
        if (s.getPlan().compareTo("Combined") == 0) {
            if (s.getMinutes() > 350) {
                return (300 + (s.getMinutes() - 350) * 0.34);
            } else return 300;
        }
        if (s.getPlan().compareTo("Time-based") == 0) {
            return (180 + s.getMinutes() * 0.38);
        }
        return (-1);
    }

    public static String choosePlan(){
        System.out.println("1) Unlimited");
        System.out.println("2) Combined");
        System.out.println("3) Timed-Based");
        switch (Integer.valueOf(sc.next())) {
            case 1:
                return ("Unlimited");
            case 2:
                return ("Combined");
            case 3:
                return ("Time-based");
            default:
                System.out.println("Incorrect input. Try again!");
                break;
        }
        return null;
    }
}