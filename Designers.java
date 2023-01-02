package finalproject;

import java.util.ArrayList;

public class Designers {

    public static void designers(ArrayList<FieldsIkea> ikeaList) {
        ArrayList<String> designerList = new ArrayList<>();
        String[] tempString;

        for (int i = 0; i < ikeaList.size(); i++) {
            if (ikeaList.get(i).getDesigner().charAt(0) != 34 && (ikeaList.get(i).getDesigner().charAt(0) < 48
                    || ikeaList.get(i).getDesigner().charAt(0) > 57)) {
                tempString = ikeaList.get(i).getDesigner().split("/");
                for (int j = 0; j < tempString.length; j++)
                    designerList.add(tempString[j]);

            }
        }

        for (int a = 0; a < designerList.size(); a++)
            System.out.println(designerList.get(a));

    }
}