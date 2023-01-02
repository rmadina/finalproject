package finalproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OperationsOnList {
    public static void operatingOnList(String[] columnNames, ArrayList<FieldsIkea> ikeaList) {
        Scanner scanner = new Scanner(System.in);
        boolean goOn = true;
        while (goOn) {
            // #region
            System.out.println("Please select what you want to do on dataset:");

            System.out.println("Print \"list\" for listing");
            // System.out.println("Print \"listSorted\" for listing sorted list");
            System.out.println("Print \"sort\" for sorting");
            // System.out.println("Print \"sortSorted\" for sorting again a sorted list");
            System.out.println("Print \"search\" for searching");
            System.out.println("Print \"columns\" for listing column names");
            // System.out.println("Print \"filter\" for filtering");
            System.out.println("Print \"designers\" for listing designers");
            System.out.println("Print \"separateCategory\" for separating and storing selected category in .csv file");
            System.out.println("Print \"exit\" for exit");

            String command = scanner.nextLine().toLowerCase();
            // #endregion

            // #region
            if (command.equals("list"))
                Listing.listing(ikeaList);

            // else if (command.equals("listsorted"))
            // Listing.listingSorted();

            else if (command.equals("sort"))
                Sorting.sorting(ikeaList);

            // else if (command.equals("sortsorted"))
            // Sorting.sortingSorted(ikeaList);

            else if (command.equals("search"))
                Search.searching(ikeaList);

            else if (command.equals("columns"))
                System.out.println(Arrays.toString(columnNames));

            else if (command.equals("filter"))
                Filtering.filtering();

            else if (command.equals("designers"))
                Designers.designers(ikeaList);

            else if (command.equals("separatecategory")) {
                ArrayList<FieldsIkea> modifiedCategoryList = new ArrayList<>();
                String selectedCategory;
                System.out.print("\nChoose category(e.g. Beds): ");
                selectedCategory = scanner.nextLine().toLowerCase();

                for (int i = 0; i < ikeaList.size(); i++)
                    if (selectedCategory.equals(ikeaList.get(i).getCategory().toLowerCase()))
                        modifiedCategoryList.add(ikeaList.get(i));

                CsvSeparator.separating(modifiedCategoryList);

            } else if (command.equals("exit"))
                break;

            else {
                System.out.println("\nPlease print accurately\n");
                continue;
            }
            // #endregion

            System.out.println("\nDo you want to do another action on list? (true/false)");
            goOn = scanner.nextBoolean();
            System.out.println();
            scanner.nextLine();//
        }
        System.out.print("----END----");
    }
}
