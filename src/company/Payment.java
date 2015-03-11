package company;

import java.util.List;
import java.util.Scanner;
public class Payment {
    /**
     * @param s - абонент
     * @return сумма, которую абонент должен оплатить, в зависимости от указанного тарифного плана.
     */
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
        } else {
            System.out.println("Current subscriber has an invalid plan.");
            return (-1);
        }
    }
}