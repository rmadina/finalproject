package finalproject;

import java.util.*;

public class Sorting {
    static ArrayList<FieldsIkea> sortedList;//

    public static void sorting(ArrayList<FieldsIkea> ikeaList) {
        Scanner scanner = new Scanner(System.in);
        sortedList = ikeaList;

        System.out.print("\nSort based on field(e.g. itemId): ");
        String selectedField = scanner.nextLine();

        System.out.println("Print \"asc\" for sorting and printing in ascending order");
        System.out.println("Print \"desc\" for sorting and printing in descending order");
        String sortingOrder = scanner.nextLine();

        Map<String, Comparator<? super FieldsIkea>> sortingOptions = new HashMap<>();

        sortingOptions.put("id-asc", Comparator.comparing(FieldsIkea::getId));
        sortingOptions.put("id-desc", Comparator.comparing(FieldsIkea::getId).reversed());

        sortingOptions.put("itemid-asc", Comparator.comparing(FieldsIkea::getItemId));
        sortingOptions.put("itemid-desc", Comparator.comparing(FieldsIkea::getItemId).reversed());

        sortingOptions.put("name-asc", Comparator.comparing(FieldsIkea::getName));
        sortingOptions.put("name-desc", Comparator.comparing(FieldsIkea::getName).reversed());

        sortingOptions.put("category-asc", Comparator.comparing(FieldsIkea::getCategory));
        sortingOptions.put("category-desc", Comparator.comparing(FieldsIkea::getCategory).reversed());

        sortingOptions.put("price-asc", Comparator.comparing(FieldsIkea::getPrice));
        sortingOptions.put("price-desc", Comparator.comparing(FieldsIkea::getPrice).reversed());

        sortingOptions.put("oldprice-asc", Comparator.comparing(FieldsIkea::getOldPrice));
        sortingOptions.put("oldprice-desc", Comparator.comparing(FieldsIkea::getOldPrice).reversed());

        sortingOptions.put("sellableonline-asc", Comparator.comparing(FieldsIkea::getSellableOnline));
        sortingOptions.put("sellableonline-desc", Comparator.comparing(FieldsIkea::getSellableOnline).reversed());

        sortingOptions.put("link-asc", Comparator.comparing(FieldsIkea::getLink));
        sortingOptions.put("link-desc", Comparator.comparing(FieldsIkea::getLink).reversed());

        sortingOptions.put("othercolors-asc", Comparator.comparing(FieldsIkea::getOtherColors));
        sortingOptions.put("othercolors-desc", Comparator.comparing(FieldsIkea::getOtherColors).reversed());

        sortingOptions.put("shortdescription-asc", Comparator.comparing(FieldsIkea::getShortDescription));
        sortingOptions.put("shortdescription-desc", Comparator.comparing(FieldsIkea::getShortDescription).reversed());

        sortingOptions.put("designer-asc", Comparator.comparing(FieldsIkea::getDesigner));
        sortingOptions.put("designer-desc", Comparator.comparing(FieldsIkea::getDesigner).reversed());

        sortingOptions.put("depth-asc", Comparator.comparing(FieldsIkea::getDepth));
        sortingOptions.put("depth-desc", Comparator.comparing(FieldsIkea::getDepth).reversed());

        sortingOptions.put("height-asc", Comparator.comparing(FieldsIkea::getHeight));
        sortingOptions.put("height-desc", Comparator.comparing(FieldsIkea::getHeight).reversed());

        sortingOptions.put("width-asc", Comparator.comparing(FieldsIkea::getWidth));
        sortingOptions.put("width-desc", Comparator.comparing(FieldsIkea::getWidth).reversed());

        try {
            sortedList.sort(sortingOptions.get(selectedField.toLowerCase() + "-" + sortingOrder.toLowerCase()));
            for (int i = 0; i < sortedList.size(); i++) {
                System.out.println(sortedList.get(i) + "\n");
            }
        } catch (NullPointerException npe) {
            System.out.println("Value of some field is null. Sort cannot be completed.");
        }

    }

    public static ArrayList<FieldsIkea> getSortedList() {
        return sortedList;
    }

}
