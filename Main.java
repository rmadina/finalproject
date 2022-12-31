package projectfin;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String... args) {
        // #region
        boolean goOn = true;
        Scanner scanner = new Scanner(System.in);
        ArrayList<FieldsIkea> productList = new ArrayList<>();

        try (FileReader fr = new FileReader("D:\\pp2\\projectfin\\ikeaText.txt");
                BufferedReader br = new BufferedReader(fr);) {

            br.readLine();
            String tempString;
            String fields[];


            while ((tempString = br.readLine()) != null) {

                fields = tempString.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                FieldsIkea fieldsIkea = new FieldsIkea(fields);
                productList.add(fieldsIkea);
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
            System.out.println("3 for searching");
            System.out.println("4 for exit");

            String command = scanner.nextLine();
            // #endregion

            // #region

            if (command.equals("1")) {

                System.out.println("\nChoose selection format:");
                System.out.println("1 for listing randomly selected n entities");
                System.out.println("2 for listing top n entities");
                System.out.println("3 for listing bottom n entities");
                System.out.println("4 for exit");

                String selectionFormat = scanner.nextLine();

                if (selectionFormat.equals("1")) {
                    System.out.println("\nPlease print number of random entities to be listed: ");//
                    int entities = scanner.nextInt();
                    Listing.randomEntities(productList, entities);
                }

                else if (selectionFormat.equals("2")) {
                    System.out.println("\nPlease select number of top entities to be listed:");
                    int listCount2 = scanner.nextInt();
                    Listing.topEntities(productList, listCount2);
                }

                else if (selectionFormat.equals("3")) {
                    System.out.println("\nPlease select number of bottom entities to be listed:");
                    int listCount3 = scanner.nextInt();
                    Listing.bottomEntities(productList, listCount3);
                } else if (selectionFormat.equals("4")) {
                    break;
                }

                else {
                    System.out.println("Please choose numbers between 1-4\n");
                    continue;
                }

            }
            // #endregion

            // #region
            else if (command.equals("2")) {
                // Sorting.sorting(productList);

            } else if (command.equals("3")) {
                // Searching.searching(productList);4

            }

            else if (command.equals("4"))
                break;
            else {
                System.out.println("Please choose numbers between 1-4\n");
                continue;
            }

            // We can accomplish same thing in the above code(last "else")through exceptions
            // try {
            // throw new Exception();
            // } catch (Exception e) {
            // System.out.println("Please choose numbers between 1-4\n");
            // continue;
            // }

            System.out.println("\nDo you want to do another action on list? (true/false)");
            goOn = scanner.nextBoolean();
            System.out.println();

        }
        System.out.print("----END----");

        scanner.close();
        // #endregion
    }

}
