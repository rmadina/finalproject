package finalproject;

import java.io.*;
import java.util.*;

class Main {
    static String columnNames = "";

    public static void main(String... args) {
        // #region
        ArrayList<FieldsIkea> ikeaList = new ArrayList<>();

        try (FileReader fr = new FileReader("C:\\Users\\Nahid\\Documents\\GitHub\\finalproject\\ikeaText.csv");
                BufferedReader br = new BufferedReader(fr);) {

            columnNames = br.readLine();
            String tempString;
            String fields[];

            while ((tempString = br.readLine()) != null) {

                fields = tempString.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                FieldsIkea fieldsIkea = new FieldsIkea(fields);
                ikeaList.add(fieldsIkea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // #endregion

        OperationsOnList.operatingOnList(columnNames, ikeaList);

    }

}
