package finalproject;

import java.util.*;

public class Sorting {

    public static void sorting(ArrayList<String> entireList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1 for sorting based on item id");
        System.out.println("2 for sorting based on item name");
        int sortingWay = scanner.nextInt();

        if (sortingWay == 1) {

            String entities[];
            ArrayList<Integer> itemIdArrayList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {//
                entities = entireList.get(i + 1).split(",");
                itemIdArrayList.add(Integer.parseInt(entities[1]));
            }

            System.out.println("\nASC for sorting in Ascending order");
            System.out.println("DESC for sorting in Descending order");
            scanner.nextLine();
            String orderOfSorting = scanner.nextLine();

            if (orderOfSorting.equals("ASC")) {
                System.out.println("Before sorting: " + itemIdArrayList);// print entities not item ids
                Collections.sort(itemIdArrayList);
                System.out.println("After sorting(ASC): " + itemIdArrayList);
            }

            if (orderOfSorting.equals("DESC")) {
                System.out.println(itemIdArrayList);
                Collections.sort(itemIdArrayList, Collections.reverseOrder());
                System.out.println(itemIdArrayList);
            }

        }

        if (sortingWay == 2) {

        }

    }

}
