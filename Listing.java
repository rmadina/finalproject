package finalproject;

import java.util.*;

public class Listing {

    public static void randomEntities(ArrayList<String> entireList, int entities) {
        ArrayList<String> randomList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i < entities; i++) {
            int r;
            System.out.println(entireList.get(r = random.nextInt(0, 3694)) + "\n");
            randomList.add(entireList.get(r));

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
            fields = randomList.get(selectedEntity).split(",");

            System.out.print("Select field(starting from 0): ");
            int selectedField = sc.nextInt();
            System.out.println(fields[selectedField]);
        }

    }

    public static void topEntities(ArrayList<String> entireList, int entities) {
        ArrayList<String> topList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < entities; i++) {
            System.out.println(entireList.get(i) + "\n");
            topList.add(entireList.get(i));
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
            fields = topList.get(selectedEntity).split(",");

            System.out.print("Select field(starting from 0): ");
            int selectedField = sc.nextInt();
            System.out.println(fields[selectedField]);
        }

    }

    public static void bottomEntities(ArrayList<String> entireList, int entities) {
        ArrayList<String> bottomList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        for (int i = entireList.size() - 1; i > entireList.size() - (entities + 1); i--) {
            System.out.println(entireList.get(i) + "\n");
            bottomList.add(entireList.get(i));
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
            fields = bottomList.get(selectedEntity).split(",");

            System.out.print("Select field(starting from 0): ");
            int selectedField = sc.nextInt();
            System.out.println(fields[selectedField]);
        }

    }
}
