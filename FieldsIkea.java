package finalproject;

public class FieldsIkea {

    private Integer id;
    private Integer itemId;
    private String name;
    private String category;
    private Float price;
    private String oldPrice;
    private Boolean sellableOnline;
    private String link;
    private String otherColors;
    private String shortDescription;
    private String designer;
    private Float depth;
    private Float height;
    private Float width;

    public FieldsIkea() {

    }

    public FieldsIkea(String[] fields) {
        id = Integer.parseInt(fields[0]);
        itemId = Integer.parseInt(fields[1]);
        name = fields[2];
        category = fields[3];
        price = (fields[4] == null || fields[4] == "") ? 0 : Float.parseFloat(fields[4]);
        oldPrice = fields[5];
        sellableOnline = Boolean.parseBoolean(fields[6]);
        link = fields[7];
        otherColors = fields[8];
        shortDescription = fields[9];
        designer = fields[10];

        if (fields.length <= 11) {
            depth = 0.0f;
            height = 0.0f;
            width = 0.0f;
        } else if (fields.length <= 12) {
            depth = (fields[11] == null || fields[11] == "") ? 0.0f : Float.valueOf(fields[11]);
            height = 0.0f;
            width = 0.0f;
        } else if (fields.length <= 13) {
            depth = (fields[11] == null || fields[11] == "") ? 0.0f : Float.valueOf(fields[11]);
            height = (fields[12] == null || fields[12] == "") ? 0.0f : Float.valueOf(fields[12]);
            width = 0.0f;
        } else {
            depth = (fields[11] == null || fields[11] == "") ? 0.0f : Float.valueOf(fields[11]);
            height = (fields[12] == null || fields[12] == "") ? 0.0f : Float.valueOf(fields[12]);
            width = (fields[13] == null || fields[13] == "") ? 0.0f : Float.valueOf(fields[13]);
        }

    }

    public String getSelectedField(String selectedField) {

        String fieldValue = "";

        switch (selectedField) {
            case "id":
                fieldValue = getId().toString();
                break;
            case "itemid":
                fieldValue = getItemId().toString();
                break;
            case "name":
                fieldValue = getName();
                break;
            case "category":
                fieldValue = getCategory();
                break;
            case "price":
                fieldValue = getPrice().toString();
                break;
            case "oldprice":
                fieldValue = getOldPrice();
                break;
            case "sellableonline":
                fieldValue = getSellableOnline().toString();
                break;
            case "link":
                fieldValue = getLink();
                break;
            case "othercolors":
                fieldValue = getOtherColors();
                break;
            case "shortdescription":
                fieldValue = getShortDescription();
                break;
            case "designer":
                fieldValue = getDesigner();
                break;
            case "depth":
                fieldValue = getDepth().toString();
                break;
            case "height":
                fieldValue = getHeight().toString();
                break;
            case "width":
                fieldValue = getWidth().toString();
                break;

        }

        return fieldValue;
    }

    // #region
    public Integer getId() {
        return id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Float getPrice() {
        return price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public Boolean getSellableOnline() {
        return sellableOnline;
    }

    public String getLink() {
        return link;
    }

    public String getOtherColors() {
        return otherColors;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDesigner() {
        return designer;
    }

    public Float getDepth() {
        return depth;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWidth() {
        return width;
    }

    // #endregion

    @Override
    public String toString() {
        return "FieldsIkea [id=" + id + ", itemId=" + itemId + ", name=" + name + ", category=" + category + ", price="
                + price + ", oldPrice=" + oldPrice + ", sellableOnline=" + sellableOnline + ", link=" + link
                + ", otherColors=" + otherColors + ", shortDescription=" + shortDescription + ", designer=" + designer
                + ", depth=" + depth
                + ", height=" + height + ", width=" + width + "]";
    }

    public String toCsvString() {
        return id + "," + itemId + "," + name + "," + category + ","
                + price + "," + oldPrice + "," + sellableOnline + "," + link
                + "," + otherColors + "," + shortDescription + "," + designer
                + "," + depth
                + "," + height + "," + width + "\n";
    }

    public String getStringField(String fieldName) {

        switch (fieldName) {
            case "name":
                return getName();
            case "category":
                return getCategory();
            case "oldprice":
                return getOldPrice();
            case "link":
                return getLink();
            case "othercolors":
                return getOtherColors();
            case "shortdescription":
                return getShortDescription();
            case "designer":
                return getShortDescription();
            default:
                return "";
        }
    }

    public Float getFloatField(String fieldName) {

        switch (fieldName) {
            case "price":
                return getPrice();
            case "depth":
                return getDepth();
            case "height":
                return getHeight();
            case "width":
                return getWidth();
            default:
                return 0f;
        }
    }

    public Integer getIntegerField(String fieldName) {

        switch (fieldName) {
            case "id":
                return getId();
            case "itemid":
                return getItemId();
            default:
                return 0;
        }
    }

    public Boolean getBooleanField(String fieldName) {

        switch (fieldName) {
            case "sellableonline":
                return getSellableOnline();
        }

        return false;
    }

}
