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

        // try{
        if (fields.length > 11)
            depth = (fields[11] == null || fields[11] == "") ? 0 : Float.parseFloat(fields[11]);

        if (fields.length > 12)
            height = (fields[12] == null || fields[12] == "") ? 0 : Float.parseFloat(fields[12]);

        if (fields.length > 13)
            width = (fields[13] == null || fields[13] == "") ? 0 : Float.parseFloat(fields[13]);

        // }
        // catch(Exception ex){
        // System.out.println(fields[0]);
        // return;
        // }
        // depth = Float.parseFloat(fields[11] == null || fields[11] == "" ? "0" :
        // fields[11]);
        // height = Float.parseFloat(fields[12]);
        // width = Float.parseFloat(fields[13]);

    }

    public String getSelectedField(String selectedField) {

        String fieldValue = "";

        switch (selectedField) {
            case "id":
                fieldValue = getIdString();
                break;
            case "itemId":
                fieldValue = getItemIdString();
                break;
            case "name":
                fieldValue = getName();
                break;
            case "category":
                fieldValue = getCategory();
                break;
            case "price":
                fieldValue = getPriceString();
                break;
            case "oldPrice":
                fieldValue = getOldPrice();
                break;
            case "sellableOnline":
                fieldValue = getSellableOnlineString();
                break;
            case "otherColors":
                fieldValue = getOtherColors();
                break;
            case "shortDescription":
                fieldValue = getShortDescription();
                break;
            case "designer":
                fieldValue = getDesigner();
                break;
            case "depth":
                fieldValue = getDepthString();
                break;
            case "height":
                fieldValue = getHeightString();
                break;
            case "width":
                fieldValue = getWidthString();
                break;

        }

        return fieldValue;
    }

    // #region
    public Integer getId() {
        return id;
    }

    public String getIdString() {
        return id.toString();
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemIdString() {
        return itemId.toString();
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

    public String getPriceString() {
        return price.toString();
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public Boolean getSellableOnline() {
        return sellableOnline;
    }

    public String getSellableOnlineString() {
        return sellableOnline.toString();
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

    public String getDepthString() {
        return depth.toString();
    }

    public Float getHeight() {
        return height;
    }

    public String getHeightString() {
        return height.toString();
    }

    public Float getWidth() {
        return width;
    }
    
    public String getWidthString() {
        return width.toString();
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

}
