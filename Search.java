package finalproject;

import java.util.*;

public class Search {

    public static void searching(ArrayList<FieldsIkea> list) {
        ArrayList<FieldsIkea> searchedList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease print field of search: ");
        String selectedField = scanner.nextLine().toLowerCase();
        System.out.println("Please print value of search: ");
        String valueOfSearch = scanner.nextLine().toLowerCase();

        for (int i = 0; i < list.size(); i++) {
            if (valueOfSearch.equals(list.get(i).getSelectedField(selectedField).toLowerCase())) {
                searchedList.add(list.get(i));
                System.out.println(list.get(i));
            }
        }

        while (true) {
            System.out.println("\nTo store the result in separate .csv file?(yes/no):");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                CsvSeparator.separating(searchedList);
                
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
