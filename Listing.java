package projectfin;

import java.util.*;

public class Listing {

    public static void randomEntities(ArrayList<FieldsIkea> productList, int entities) {
        ArrayList<FieldsIkea> randomList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < entities; i++) {
            int r;
            System.out.println(productList.get(r = random.nextInt(0, 3694)) + "\n");
            randomList.add(productList.get(r));

        }

        System.out.println("1 for printing all fields of selected entity");
        System.out.println("2 for printing selected field of selected entity");
        System.out.println("3 for exit");
        int displayFormat = sc.nextInt();

        if (displayFormat == 1) {
            System.out.print("\nSelect entity(starting from 0): ");
            int selectedEntity = sc.nextInt();
            System.out.println(randomList.get(selectedEntity));
        }

        if (displayFormat == 2) {
            String[] fields;
            System.out.print("\nSelect entity(starting from 0): ");
            int selectedEntity = sc.nextInt();

            System.out.print("Select field: ");
            sc.nextLine();
            String selectedField = sc.nextLine();
            randomList.get(selectedEntity).printSelectedField(selectedField);
        }

    }

    // #region
    public static void topEntities(ArrayList<FieldsIkea> productList, int entities) {
        ArrayList<FieldsIkea> topList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < entities; i++) {
            System.out.println(productList.get(i) + "\n");
            topList.add(productList.get(i));
        }

        System.out.println("1 for printing all fields of selected entity");
        System.out.println("2 for printing selected field of selected entity");
        System.out.println("3 for exit");
        int displayFormat = sc.nextInt();

        if (displayFormat == 1) {
            System.out.print("\nSelect entity(starting from 0): ");
            int selectedEntity = sc.nextInt();
            System.out.println(topList.get(selectedEntity));
        }

        if (displayFormat == 2) {
            String[] fields;
            System.out.print("\nSelect entity(starting from 0): ");
            int selectedEntity = sc.nextInt();

            System.out.print("Select field: ");
            sc.nextLine();
            String selectedField = sc.nextLine();
            topList.get(selectedEntity).printSelectedField(selectedField);

        }

    }

    // #endregion
    // #region
    public static void bottomEntities(ArrayList<FieldsIkea> productList, int entities) {
        ArrayList<FieldsIkea> bottomList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = productList.size() - 1; i > productList.size() - (entities + 1); i--) {
            System.out.println(productList.get(i) + "\n");
            bottomList.add(productList.get(i));
        }

        System.out.println("1 for printing all fields of selected entity");
        System.out.println("2 for printing selected field of selected entity");
        System.out.println("3 for exit");
        int displayFormat = sc.nextInt();

        if (displayFormat == 1) {
            System.out.print("\nSelect entity(starting from 0): ");
            int selectedEntity = sc.nextInt();
            System.out.println(bottomList.get(selectedEntity));
        }

        if (displayFormat == 2) {
            String[] fields;
            System.out.print("\nSelect entity(starting from 0): ");
            int selectedEntity = sc.nextInt();

            System.out.print("Select field(starting from 0): ");
            sc.nextLine();
            String selectedField = sc.nextLine();
            bottomList.get(selectedEntity).printSelectedField(selectedField);
        }
    }
    // #endregion

}
