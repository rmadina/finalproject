package finalproject;

import java.io.*;
import java.util.*;

class IkeaProducts {
    public static void main(String... args) {
        // #region
        boolean goOn = true;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> entireList = new ArrayList<String>();

        try (FileReader fr = new FileReader("D:\\pp2\\finalproject\\ikeaText.txt");
                BufferedReader br = new BufferedReader(fr);) {

            String myString;
            while ((myString = br.readLine()) != null) {
                entireList.add(myString);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // #endregion

        // #region
        while (goOn) {

            System.out.println("Please select what you want to do with list.");

            System.out.println("1 for selecting from list");
            System.out.println("2 for sorting");
            System.out.println("3 for exit");

            int command = scanner.nextInt();
            // #endregion

            // #region
            // Selecting
            if (command == 1) {

                System.out.println("\nChoose selection format:");
                System.out.println("1 for listing randomly selected n entities");
                System.out.println("2 for listing top n entities");
                System.out.println("3 for listing bottom n entities");
                int selectionFormat = scanner.nextInt();

                if (selectionFormat == 1) {
                    System.out.println("\nPlease print number of random entities to be listed: ");
                    int listCount1 = scanner.nextInt();
                    Listing.randomEntities(entireList, listCount1);
                }

                // if (selectionFormat == 2) {
                //     System.out.println("\nPlease select number of top entities to be listed:");
                //     int listCount2 = scanner.nextInt();
                //     Listing.topEntities(entireList, listCount2);
                // }
                // if (selectionFormat == 3) {
                //     System.out.println("\nPlease select number of bottom entities to be listed:");
                //     int listCount3 = scanner.nextInt();
                //     Listing.bottomEntities(entireList, listCount3);
                // }

            }
            // #endregion
            





            // Sorting
            if (command == 2) {
                Sorting.sorting(entireList);
                
                
            }

            if (command == 3)
                break;

            System.out.println("\nDo you want to do another action on list? (true/false)");
            goOn = scanner.nextBoolean();
            System.out.println();

        }
        System.out.print("----END----");

        scanner.close();

    }

  
}
