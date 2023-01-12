package finalproject;

public class FilterParameter {

    private String fieldName;
    private FieldTypeEnum fieldType;
    private SearchFormatEnum searchFormat;
    private String filterValue;

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldType(FieldTypeEnum fieldType) {
        this.fieldType = fieldType;
    }

    public void setSearchFormat(SearchFormatEnum searchFormat) {
        this.searchFormat = searchFormat;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public FieldTypeEnum getFieldType() {
        return fieldType;
    }

    public SearchFormatEnum getSearchFormat() {
        return searchFormat;
    }

    public String getFilterValue() {
        return filterValue;
    }

}