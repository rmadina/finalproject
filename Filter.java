package finalproject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filter {
    // #region
    static Field[] ikeaFields = FieldsIkea.class.getDeclaredFields();

    public static FieldTypeEnum getFieldType(String fieldName) {//

        for (int i = 0; i < ikeaFields.length; i++) {

            if (ikeaFields[i].getName().toLowerCase().equals(fieldName)) {
                String type = ikeaFields[i].getType().getSimpleName();

                if (type.equals("String")) {
                    return FieldTypeEnum.StringFilter;
                } else if (type.equals("Boolean")) {
                    return FieldTypeEnum.BooleanFilter;
                } else if (type.equals("Float")) {
                    return FieldTypeEnum.FloatFilter;
                } else
                    return FieldTypeEnum.IntegerFilter;
            }
        }
        return null;
    }

    // #endregion

    public static void filtering(ArrayList<FieldsIkea> ikeaList) {
        // #region
        List<FieldsIkea> filteredList = new ArrayList<>(ikeaList);
        Scanner scanner = new Scanner(System.in);
        boolean addFilter = true;
        Field[] ikeaFields = FieldsIkea.class.getDeclaredFields();

        ArrayList<String> ikeaFieldNames = new ArrayList<>();
        for (int i = 0; i < ikeaFields.length; i++) {
            ikeaFieldNames.add(ikeaFields[i].getName().toLowerCase());
        }

        ArrayList<FilterParameter> filterParameters = new ArrayList<>();
        // #endregion

        while (addFilter) {

            FilterParameter filterParameter = new FilterParameter();
            System.out.print("\nPlease print field for filtering: ");

            String fieldName = scanner.nextLine().toLowerCase();

            if (!ikeaFieldNames.stream().anyMatch(x -> x.equals(fieldName))) {
                System.out.println("Parameter you entered is not valid!");
                continue;
            }

            FieldTypeEnum fieldTypeEnum = getFieldType(fieldName);

            filterParameter.setFieldName(fieldName);
            filterParameter.setFieldType(fieldTypeEnum);

            SearchFormatEnum searchFormatEnum;

            while (true) {
                if (fieldTypeEnum == FieldTypeEnum.StringFilter) {
                    System.out.println("\nPlease select search format:");
                    System.out.println("contains (c)");
                    System.out.println("null or missing (nm)");

                    String searchFormat = scanner.nextLine().toLowerCase();

                    if (searchFormat.equals("c")) {
                        searchFormatEnum = SearchFormatEnum.Contains;
                        break;
                    } else if (searchFormat.equals("nm")) {
                        searchFormatEnum = SearchFormatEnum.NullOrMissing;
                        break;
                    } else {
                        System.out.println("Search format you entered is not valid!");
                        continue;
                    }

                }

                else if (fieldTypeEnum == FieldTypeEnum.FloatFilter || fieldTypeEnum == FieldTypeEnum.IntegerFilter) {

                    System.out.println("Please select search format:");
                    System.out.println("equal (eq)");
                    System.out.println("greater than (gt)");
                    System.out.println("less than (lt)");
                    System.out.println("greater and equal to (ge)");
                    System.out.println("less and equal to (le)");
                    System.out.println("between (bt)");
                    System.out.println("null or missing (nm))");

                    String searchFormat = scanner.nextLine().toLowerCase();

                    if (searchFormat.equals("eq")) {
                        searchFormatEnum = SearchFormatEnum.Equal;
                        break;
                    } else if (searchFormat.equals("gt")) {
                        searchFormatEnum = SearchFormatEnum.GreaterThan;
                        break;
                    } else if (searchFormat.equals("lt")) {
                        searchFormatEnum = SearchFormatEnum.LessThan;
                        break;
                    } else if (searchFormat.equals("ge")) {
                        searchFormatEnum = SearchFormatEnum.GreaterAndEqualTo;
                        break;
                    }
                    if (searchFormat.equals("le")) {
                        searchFormatEnum = SearchFormatEnum.LessAndEqualTo;
                        break;
                    } else if (searchFormat.equals("bt")) {
                        searchFormatEnum = SearchFormatEnum.Between;
                        break;
                    } else if (searchFormat.equals("nm")) {
                        searchFormatEnum = SearchFormatEnum.NullOrMissing;
                        break;
                    } else {
                        System.out.println("Search format you entered is not valid!");
                        continue;
                    }
                } else {
                    searchFormatEnum = SearchFormatEnum.Equal;
                    break;
                }

            }
            // #region
            filterParameter.setSearchFormat(searchFormatEnum);

            String filterValue;
            if (!searchFormatEnum.equals(SearchFormatEnum.NullOrMissing)) {
                System.out.print("\nPlease print filter value: ");
                filterValue = scanner.nextLine().toLowerCase();//
                filterParameter.setFilterValue(filterValue);
            } else {
                filterParameter.setFilterValue("0");
            }

            filterParameters.add(filterParameter);

            System.out.print("\nDo you want add another filter?(true/false): ");
            addFilter = scanner.nextBoolean();
            scanner.nextLine();
            // #endregion
        }

        // #region
        for (FilterParameter filterParameter : filterParameters) {

            if (filterParameter.getFieldType().equals(FieldTypeEnum.StringFilter)) {

                if (filterParameter.getSearchFormat().equals(SearchFormatEnum.Contains)) {

                    filteredList = filteredList.stream().filter(x -> x.getStringField(filterParameter.getFieldName())
                            .toLowerCase().contains(filterParameter.getFilterValue())).toList();

                } else {// null or missing
                    filteredList = filteredList.stream()
                            .filter(x -> x.getStringField(filterParameter.getFieldName()) == null
                                    || x.getStringField(filterParameter.getFieldName()).replace(" ", "") == "")
                            .toList();
                }

            } else if (filterParameter.getFieldType().equals(FieldTypeEnum.FloatFilter)) {

                if (filterParameter.getSearchFormat().equals(SearchFormatEnum.Between)) {

                    if (filterParameter.getFilterValue().contains(",")) {

                        String[] filterValues = filterParameter.getFilterValue().split(",");

                        Float filterValueMin = Float.parseFloat(filterValues[0]);
                        Float filterValueMax = Float.parseFloat(filterValues[1]);

                        filteredList = filteredList.stream()
                                .filter(x -> x.getFloatField(filterParameter.getFieldName()) > filterValueMin
                                        && x.getFloatField(filterParameter.getFieldName()) < filterValueMax)
                                .toList();
                    }
                } else {
                    Float filterValue = Float.parseFloat(filterParameter.getFilterValue());

                    if (filterParameter.getSearchFormat().equals(SearchFormatEnum.Equal)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getFloatField(filterParameter.getFieldName()).equals(filterValue))
                                .toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.GreaterThan)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getFloatField(filterParameter.getFieldName()) > filterValue).toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.LessThan)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getFloatField(filterParameter.getFieldName()) < filterValue).toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.GreaterAndEqualTo)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getFloatField(filterParameter.getFieldName()) >= filterValue).toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.LessAndEqualTo)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getFloatField(filterParameter.getFieldName()) <= filterValue).toList();

                    } else {// null or missing
                        filteredList = filteredList.stream()
                                .filter(x -> x.getFloatField(filterParameter.getFieldName()) == null).toList();
                    }
                }

            } else if (filterParameter.getFieldType().equals(FieldTypeEnum.IntegerFilter)) {
                if (filterParameter.getSearchFormat().equals(SearchFormatEnum.Between)) {

                    if (filterParameter.getFilterValue().contains(",")) {

                        String[] filterValues = filterParameter.getFilterValue().split(",");

                        Integer filterValueMin = Integer.valueOf(filterValues[0]);
                        Integer filterValueMax = Integer.valueOf(filterValues[1]);

                        filteredList = filteredList.stream()
                                .filter(x -> x.getIntegerField(filterParameter.getFieldName()) > filterValueMin
                                        && x.getIntegerField(filterParameter.getFieldName()) < filterValueMax)
                                .toList();
                    }
                } else {
                   

                    Integer filterValue = Integer.valueOf(filterParameter.getFilterValue());

                    if (filterParameter.getSearchFormat().equals(SearchFormatEnum.Equal)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getIntegerField(filterParameter.getFieldName()).equals(filterValue))
                                .toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.GreaterThan)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getIntegerField(filterParameter.getFieldName()) > filterValue).toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.LessThan)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getIntegerField(filterParameter.getFieldName()) < filterValue).toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.GreaterAndEqualTo)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getIntegerField(filterParameter.getFieldName()) >= filterValue).toList();

                    } else if (filterParameter.getSearchFormat().equals(SearchFormatEnum.LessAndEqualTo)) {

                        filteredList = filteredList.stream()
                                .filter(x -> x.getIntegerField(filterParameter.getFieldName()) <= filterValue).toList();

                    } else {// null or missing
                        filteredList = filteredList.stream()
                                .filter(x -> x.getIntegerField(filterParameter.getFieldName()) == null).toList();
                    }
                }

            } else {// FieldTypeEnum.BooleanFilter

                Boolean filterValue = Boolean.parseBoolean(filterParameter.getFilterValue());

                filteredList = filteredList.stream()
                        .filter(x -> x.getBooleanField(filterParameter.getFieldName()) == filterValue).toList();
            }

        }

        // #endregion

        while (true) {
            System.out.print("\nDo you want filtered list to be printed?(yes/no): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                for (var entity : filteredList)
                    System.out.println(entity + "\n");
                break;
            } else if (answer.equals("no"))
                break;
            else {
                System.out.println("Please print accurately");
                continue;
            }

        }

        while (true) {
            System.out.print("\nTo store the result in separate .csv file?(yes/no): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                String command = "";
                CsvWriter.separating(filteredList, command);
                break;
            } else if (answer.equals("no"))
                break;
            else {
                System.out.println("Please print accurately");
                continue;
            }
        }

    }

}
