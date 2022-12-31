package projectfin;

public class FieldsIkea<T> {

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

    FieldsIkea(String[] fields) {
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
            if(fields.length>11)
                depth = (fields[11] == null || fields[11] == "") ? 0 : Float.parseFloat(fields[11]);

            if(fields.length>12)
                height = (fields[12] == null || fields[12] == "") ? 0 : Float.parseFloat(fields[12]);

            if(fields.length>13)
                width = (fields[13] == null || fields[13] == "") ? 0 : Float.parseFloat(fields[13]);

        // }
        // catch(Exception ex){
        //     System.out.println(fields[0]);
        //     return;
        // }
        // depth = Float.parseFloat(fields[11] == null || fields[11] == "" ? "0" : fields[11]);
        // height = Float.parseFloat(fields[12]);
        // width = Float.parseFloat(fields[13]);

    }

    public String printSelectedField(String selectedField) {

    String fieldValue="";

        switch (selectedField) {
            case "id":
            fieldValue = getId();
                break;
            // case "itemId":
            //     printItemId();
            //     break;
            // case "name":
            //     printName();
            //     break;
            // case "category":
            //     printCategory();
            //     break;
            // case "price":
            //     printPrice();
            //     break;
            // case "oldPrice":
            //     printOldPrice();
            //     break;
            // case "sellableOnline":
            //     printSellableOnline();
            //     break;
            // case "otherColors":
            //     printOtherColors();
            //     break;
            // case "shortDescription":
            //     printShortDescription();
            //     break;
            // case "designer":
            //     printDesigner();
            //     break;
            // case "depth":
            //     printDepth();
            //     break;
            // case "height":
            //     printHeight();
            //     break;
            // case "width":
            //     printWidth();
            //     break;

            default:
                break;
        }

        return fieldValue;
    }


    // #region
    public String getId() {
        return id.toString();
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
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

    public float getDepth() {
        return depth;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
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

}