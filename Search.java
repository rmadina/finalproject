package finalproject;

import java.lang.reflect.Field;
import java.util.*;

public class Search {

    static Field[] ikeaFields = FieldsIkea.class.getDeclaredFields();

    public static String getFieldType(String fieldName) {
        for (int i = 0; i < ikeaFields.length; i++) {
            if (ikeaFields[i].getName().toLowerCase().equals(fieldName)) {
                return ikeaFields[i].getType().getSimpleName();
            }
        }
        return null;
    }

    public static void searching(ArrayList<FieldsIkea> list) {
        ArrayList<FieldsIkea> searchedList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease print field of search: ");
        String selectedField = scanner.nextLine().toLowerCase();
        System.out.print("Please print value of search: ");
        String valueOfSearch = scanner.nextLine().toLowerCase();

        for (int i = 0; i < list.size(); i++) {

            if (getFieldType(selectedField).equals("String")) {
                if (list.get(i).getSelectedField(selectedField).toLowerCase().contains(valueOfSearch))
                    searchedList.add(list.get(i));

            } else if (getFieldType(selectedField).equals("Boolean")) {

                if (valueOfSearch.equals(list.get(i).getSelectedField(selectedField)))
                    searchedList.add(list.get(i));

            } else if (getFieldType(selectedField).equals("Float")) {
                if (Float.valueOf(valueOfSearch).equals(Float.valueOf(list.get(i).getSelectedField(selectedField)))) {
                    searchedList.add(list.get(i));
                }
            }

            else {
                if (Integer.valueOf(valueOfSearch)
                        .equals(Integer.valueOf(list.get(i).getSelectedField(selectedField))))
                    searchedList.add(list.get(i));
            }

        }

        while (true) {
            System.out.print("\nDo you want searched list to be printed?(yes/no): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                for (var entity : searchedList)
                    System.out.println(entity + "\n");
                break;
            } else if (answer.equals("no"))
                break;
            else {
                System.out.println("Please print accurately");
                continue;
            }

        }

        while (true) {
            System.out.print("To store the result in separate .csv file?(yes/no): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                String command = "";
                CsvWriter.separating(searchedList, command);
                break;
            } else if (answer.equals("no"))
                break;
            else {
                System.out.println("Please print accurately");
                continue;
            }
        }

    }
}
