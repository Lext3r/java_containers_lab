package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<Subscriber> getSubscribers(String[] args) {
        List<Subscriber> list = new ArrayList<Subscriber>();
        Scanner sc;
        try {
            for(String filename : args){
                sc = new Scanner(new File(filename));
                while (sc.hasNext()) {
                    String[] field = sc.nextLine().split(" ");
                    list.add(new Subscriber(field[0], field[1], field[2], field[3], field[4]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Wrong input files. Check it out and try again!\n");
            System.exit(-1);
        }
        return list;
    }
}
