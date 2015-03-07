package company;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Subscriber> list = FileReader.getSubscribers(args);
        while(true)
        {
            showMenu();
            System.out.println("Your choice:");
            try {
                choice(Integer.valueOf(sc.next()), list);
            } catch (NumberFormatException e){
                System.out.println("Wrong input. Try again!\n");
            }
        }
    }

    public static void showMenu(){
        System.out.println("1. Add subscriber");
        System.out.println("2. Remove subscriber");
        System.out.println("3. Find subscribers");
        System.out.println("4. Show all subscribers");
        System.out.println("5. Show payment");
        System.out.println("6. Exit\n");

    }

    public static void choice (int n, List<Subscriber> list){
        switch (n) {
            case 1:  SubList.addSubscriber(list);
                break;
            case 2:  SubList.deleteSub(list);
                break;
            case 3:  SubList.findSubs(list);
                break;
            case 4:  SubList.printSubs(list);
                break;
            case 5:
                System.out.println(Payment.getPayment(SubList.chooseSubscriber(list)));
                break;
            case 6:  System.exit(-1);
                break;
            default: System.out.println("Incorrect input. Try again!\n");
                break;
        }
    }
}
