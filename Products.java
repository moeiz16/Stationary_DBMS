package sample;

public class Products {
    String ProductID;
    String ProductName;
    String Sales_Unit_Price;
    String Purchase_Unit_Price;
    String Stock;


    public Products(String productID, String productName, String sales_Unit_Price, String purchase_Unit_Price, String stock) {
        ProductID = productID;
        ProductName = productName;
        Sales_Unit_Price = sales_Unit_Price;
        Purchase_Unit_Price = purchase_Unit_Price;
        Stock = stock;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getSales_Unit_Price() {
        return Sales_Unit_Price;
    }

    public void setSales_Unit_Price(String sales_Unit_Price) {
        Sales_Unit_Price = sales_Unit_Price;
    }

    public String getPurchase_Unit_Price() {
        return Purchase_Unit_Price;
    }

    public void setPurchase_Unit_Price(String purchase_Unit_Price) {
        Purchase_Unit_Price = purchase_Unit_Price;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }
}
