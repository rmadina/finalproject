package finalproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Separation {

    public static void separation(ArrayList<FieldsIkea> ikeaList) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<FieldsIkea> modifiedCategoryList = new ArrayList<>();
        String selectedCategory;
        System.out.print("\nChoose category(e.g. beds): ");
        selectedCategory = scanner.nextLine();

        for (int i = 0; i < ikeaList.size(); i++)
            if (selectedCategory.equals(ikeaList.get(i).getCategory()))
                modifiedCategoryList.add(ikeaList.get(i));

        try (FileWriter fw = new FileWriter("C:\\Users\\Nahid\\Documents\\GitHub\\finalproject\\selectedCategory.cvs");
                BufferedWriter bw = new BufferedWriter(fw);) {

            String newCsvString = "";
            for (var temp : modifiedCategoryList) {
                newCsvString += universityRanking;
            }
            bw.write(modifiedCategoryList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
