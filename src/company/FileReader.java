package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<Subscriber> getSubscribers(String filename) {
        List<Subscriber> list = new ArrayList<Subscriber>();
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            try {
                while (sc.hasNext()) {
                    String[] field = sc.nextLine().split(" ");
                    list.add(new Subscriber(field[0], field[1], field[2], field[3], field[4]));
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат данных в файле");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
