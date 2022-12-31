package finalproject;

import java.util.*;

public class Searching {

    public static void searching(ArrayList<String> entireList) {
        ArrayList<String[]> splittedArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease print field of search: ");
        int fieldOfSearch = scanner.nextInt();
        System.out.println("Please print value of search: ");
        scanner.nextLine();
        String valueOfSearch = scanner.nextLine();

        for (int i = 0; i < entireList.size(); i++)
            splittedArrayList.add(entireList.get(i).split(","));

        for (int entity = 0; entity < entireList.size(); entity++) {
            if (valueOfSearch.equals(splittedArrayList.get(entity)[fieldOfSearch])) {
                System.out.println(entireList.get(entity));
            }

        }

    }
}
