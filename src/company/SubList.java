package company;

import java.util.List;
import java.util.Scanner;

public class SubList {
    public static Scanner sc = new Scanner(System.in);

    public static void printSubs(List<Subscriber> list){
        for (Subscriber sub : list){
            System.out.println((list.indexOf(sub) + 1) + ")" + sub.getName() + " " + sub.getsName() + " " +
                    sub.getPhone() +  " " + sub.getPlan() + " " + sub.getMinutes());
        }
        System.out.println();
    }

    public static void deleteSub(List<Subscriber> list){
        System.out.println("List of subscribers:");
        printSubs(list);
        System.out.println("Choose number of the sub, u want to remove.");
        try {
            list.remove(Integer.valueOf(sc.next())-1);
        } catch (Exception e){
            System.out.println("Wrong Input. Try again.");
            return;
        }
        System.out.println("Removal completed");
    }

    public static void findSubs(List<Subscriber> list){
        System.out.println("Choose criteria:");
        System.out.println("1) Phone number");
        System.out.println("2) Name");
        System.out.println("3) Plan");
        switch (Integer.valueOf(sc.next())) {
            case 1:
                Subscriber.printOneSub(findSubPhone(list));
                break;
            case 2:
                Subscriber.printOneSub(findSubName(list));
                break;
            case 3:
                findSubPlan(list);
                break;
            default:
                System.out.println("Incorrect input. Try again!");
                break;
        }
    }

    public static Subscriber findSubPhone(List<Subscriber> list){
        System.out.println("Input phone number: ");
        String search = sc.next();
        for (Subscriber sub : list){
            if(search.compareTo(sub.getPhone()) == 0){
                return sub;
            }
        }
        System.out.println("No matches found");
        return null;
    }

    public static Subscriber findSubName(List<Subscriber> list){
        System.out.println("Input subscriber name: ");
        String search = sc.next();
        for (Subscriber sub : list){
            if(search.compareTo(sub.getName()) == 0){
                return sub;
            }
        }
        System.out.println("No matches found");
        return null;
    }

    public static void findSubPlan(List<Subscriber> list){
        int f = 0;
        String plan = Payment.choosePlan();
        for (Subscriber sub : list){
            if(plan.compareTo(sub.getPlan()) == 0){
                f = 1;
                Subscriber.printOneSub(sub);
            }
        }
        if (f == 0){
            System.out.println("No matches found");
        }
    }

    public static void addSubscriber(List<Subscriber> list){
        System.out.println("Input sub name:");
        String name = sc.next();
        System.out.println("Input sub surname:");
        String sName = sc.next();
        System.out.println("Input sub phone:");
        String phone = sc.next();
        while (phone.length()!= 6) {
            System.out.println("Phone number should contain 6 digit. Try again!");
            phone = sc.next();
        }
        System.out.println("Input sub plan:");
        String plan = Payment.choosePlan();
        list.add(new Subscriber(name, sName, phone, plan, "0"));
    }
}
