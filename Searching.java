package projectfin;

import java.util.*;

public class Searching {

    public static void searching(ArrayList<FieldsIkea> entireList) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease print field of search: ");
        String selectedField = scanner.nextLine();
        System.out.println("Please print value of search: ");
        String valueOfSearch = scanner.nextLine();

        for (int i = 0; i < entireList.size(); i++) {
            if (valueOfSearch == entireList.get(i).get)
                System.out.println(entireList.get(i));
        }

    }
}
