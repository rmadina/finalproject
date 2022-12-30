package finalproject;
import java.util.*;

public class Listing {

    public static void randomEntities(ArrayList<String> entireList, int entities) {
        ArrayList<String> randomList = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int r;

        for (int i = 0; i < entities; i++) {
            System.out.println(entireList.get(r = random.nextInt(1, 3694)) + "\n");
            randomList.add(entireList.get(r));
        }

        // while(goon)
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

        }
    }
}