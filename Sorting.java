package projectfin;


import java.util.*;

public class Sorting {

    public static void sorting(ArrayList<String> entireList) {
        Scanner scanner = new Scanner(System.in);
        List<IkeaDataSetField> splittedArrayList = new ArrayList<>();//

        System.out.println("\n1 for sorting based on item id");
        System.out.println("2 for sorting based on item name");
        int sortingWay = scanner.nextInt();

        if (sortingWay == 1) {

            String entities[] = new String[10];

            for (int i = 0; i < 10; i++) {//
                entities = entireList.get(i + 1).split(",");
                IkeaDataSetField idst = new IkeaDataSetField(entities);//
                splittedArrayList.add(idst);
            }

            System.out.println("\nASC for sorting in Ascending order");
            System.out.println("DESC for sorting in Descending order");
            scanner.nextLine();
            String orderOfSorting = scanner.nextLine();
            Comparator<IkeaDataSetField> dataComparator = new DataComparator();//

            // if (orderOfSorting.equals("ASC")) {

            //     Collections.sort(splittedArrayList, dataComparator.compare());//
            // }

            // if (orderOfSorting.equals("DESC")) {
                       
            // }

        }

        if (sortingWay == 2) {

        }

    }

}
