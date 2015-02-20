package company;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static List<Subscriber> list = FileReader.getSubscribers("C:\\Users\\Alex\\IdeaProjects\\java_containers_lab\\src\\company\\subscribers");

    public static void main(String[] args) {
        while(true)
        {
            showMenu();
            System.out.println("Your choice:");
            choice(Integer.valueOf(sc.next()));
        }
    }

    public static void showMenu(){
        System.out.println("1. Add subscriber");
        System.out.println("2. Remove subscriber");
        System.out.println("3. Find subscribers");
        System.out.println("4. Show all subscribers");
        System.out.println("5. Show payment");
        System.out.println("6. Exit");
        System.out.println();
    }

    public static void choice (int n){
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
                System.out.println(Payment.getPayment(Payment.chooseSubscriber(list)));
                break;
            case 6:  System.exit(-1);
                break;
            default: System.out.println("Incorrect input. Try again!");
                break;
        }
    }
}
