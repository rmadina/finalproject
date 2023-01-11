package finalproject;

import java.util.*;

public class Listing {

    public static void listing(ArrayList<FieldsIkea> list) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoose selection format:");
        System.out.println("Print \"random\" for listing and printing randomly selected n entities");
        System.out.println("Print \"top\" for listing and printing top n entities");
        System.out.println("Print \"bottom\" for listing and printing bottom n entities");
        System.out.println("Print \"exit\" for exit");
        String selectionFormat = scanner.nextLine().toLowerCase();

        if (selectionFormat.equals("random")) {
            randomEntities(list);
        }

        else if (selectionFormat.equals("top")) {
            topEntities(list);
        }

        else if (selectionFormat.equals("bottom")) {
            bottomEntities(list);
        }

        else if (selectionFormat.equals("exit")) {

        }

        else {
            System.out.println("\nPlease print accurately");
            listing(list);
        }

    }

    // #region
    public static void randomEntities(ArrayList<FieldsIkea> list) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<FieldsIkea> randomList = new ArrayList<>();

        System.out.println("\nPlease print number of random entities to be listed: ");
        int numOfEntities = scanner.nextInt();
        if (numOfEntities > 0 && numOfEntities <= list.size()) {
            for (int i = 0; i < numOfEntities; i++) {
                int r;
                System.out.println(list.get(r = random.nextInt(0, 3694)) + "\n");
                randomList.add(list.get(r));

            }

            while (true) {
                System.out.println("1 for displaying all fields of selected entity");
                System.out.println("2 for displaying selected field of selected entity");
                System.out.println("\"exit\" for exiting");
                scanner.nextLine();
                String displayFormat = scanner.nextLine();

                if (displayFormat.equals("1")) {
                    System.out.print("\nSelect entity(starting from 0): ");
                    int selectedEntity = scanner.nextInt();
                    System.out.println(randomList.get(selectedEntity));
                    break;
                }

                else if (displayFormat.equals("2")) {
                    System.out.print("\nSelect entity(starting from 0): ");
                    int selectedEntity = scanner.nextInt();

                    System.out.print("Select field: ");
                    scanner.nextLine();
                    String selectedField = scanner.nextLine().toLowerCase();
                    System.out.println(randomList.get(selectedEntity).getSelectedField(selectedField));
                    break;

                } else if (displayFormat.equals("exit")) {
                    break;
                }

                else {
                    System.out.println("\nPlease print accurately");
                }
            }

        }
    }
    // #endregion

    // #region
    public static void topEntities(ArrayList<FieldsIkea> list) {
        ArrayList<FieldsIkea> topList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlease select number of top entities to be listed:");
        int numOfEntities = scanner.nextInt();
        if (numOfEntities > 0 && numOfEntities <= list.size()) {
            for (int i = 0; i < numOfEntities; i++) {
                System.out.println(list.get(i) + "\n");
                topList.add(list.get(i));
            }

            while (true) {
                System.out.println("1 for printing all fields of selected entity");
                System.out.println("2 for printing selected field of selected entity");
                System.out.println("\"exit\" for exit");
                scanner.nextLine();
                String displayFormat = scanner.nextLine();

                if (displayFormat.equals("1")) {
                    System.out.print("\nSelect entity(starting from 0): ");
                    int selectedEntity = scanner.nextInt();
                    System.out.println(topList.get(selectedEntity));
                    break;
                }

                else if (displayFormat.equals("2")) {
                    String[] fields;
                    System.out.print("\nSelect entity(starting from 0): ");
                    int selectedEntity = scanner.nextInt();

                    System.out.print("Select field: ");
                    scanner.nextLine();
                    String selectedField = scanner.nextLine().toLowerCase();
                    System.out.println(topList.get(selectedEntity).getSelectedField(selectedField));
                    break;

                } else if (displayFormat.equals("exit")) {
                    break;
                } else {
                    System.out.println("Please print accurately");
                }
            }
        }

    }

    // #endregion
    // #region
    public static void bottomEntities(ArrayList<FieldsIkea> list) {
        ArrayList<FieldsIkea> bottomList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlease select number of bottom entities to be listed:");
        int numOfEntities = scanner.nextInt();
        if (numOfEntities > 0 && numOfEntities <= list.size()) {
            for (int i = list.size() - 1; i > list.size() - (numOfEntities + 1); i--) {
                System.out.println(list.get(i) + "\n");
                bottomList.add(list.get(i));
            }

            while (true) {
                System.out.println("1 for printing all fields of selected entity");
                System.out.println("2 for printing selected field of selected entity");
                System.out.println("3 for exit");
                scanner.nextLine();
                String displayFormat = scanner.nextLine();

                if (displayFormat.equals("1")) {
                    System.out.print("\nSelect entity(starting from 0): ");
                    int selectedEntity = scanner.nextInt();
                    System.out.println(bottomList.get(selectedEntity));
                    break;
                }

                else if (displayFormat.equals("2")) {
                    String[] fields;
                    System.out.print("\nSelect entity(starting from 0): ");
                    int selectedEntity = scanner.nextInt();

                    System.out.print("Select field: ");
                    scanner.nextLine();
                    String selectedField = scanner.nextLine().toLowerCase();
                    System.out.println(bottomList.get(selectedEntity).getSelectedField(selectedField));
                    break;

                } else if (displayFormat.equals("exit")) {
                    break;
                } else
                    System.out.println("Please print carefully");
            }
        }
        // #endregion

    }
}