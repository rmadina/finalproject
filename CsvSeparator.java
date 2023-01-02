package finalproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvSeparator {

    public static void separating(ArrayList<FieldsIkea> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose name for the file(e.g. \"name.csv\"):");
        String nameOfFile = "C:\\\\Users\\\\Nahid\\\\Documents\\\\GitHub\\\\finalproject\\\\";
        nameOfFile += scanner.nextLine();
    

        try (FileWriter fw = new FileWriter(nameOfFile);
                BufferedWriter bw = new BufferedWriter(fw);) {

            for (var temp : list) {
                bw.write(temp.toString());
                bw.newLine();
            }
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
