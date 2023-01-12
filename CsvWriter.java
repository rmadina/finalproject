package finalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CsvWriter {

    public static void separating(List<FieldsIkea> list, String command) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose name for the file: ");
        String nameOfFile = "C:\\\\Users\\\\Nahid\\\\Documents\\\\GitHub\\\\finalproject\\\\" + scanner.nextLine()
                + ".csv";

        try (FileWriter fw = new FileWriter(nameOfFile);
                BufferedWriter bw = new BufferedWriter(fw);) {

            if (!command.equals("separatecategory")) {
                bw.write(Main.columnNames);
                bw.newLine();
            }

            for (var temp : list) {
                bw.write(temp.toCsvString());
            }

            File f = new File(nameOfFile);
            if (f.length() != 0) {
                System.out.println("Done");
            } else {
                System.out.println("Something went wrong. File was not created or is empty.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
