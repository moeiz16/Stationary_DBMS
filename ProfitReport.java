package sample;

public class ProfitReport {
    String Month;
    String Total_Sales;
    String Total_Purchase;
    String Total_Profit;

    public ProfitReport(String month, String total_Sales, String total_Purchase, String total_Profit) {
        Month = month;
        Total_Sales = total_Sales;
        Total_Purchase = total_Purchase;
        Total_Profit = total_Profit;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getTotal_Sales() {
        return Total_Sales;
    }

    public void setTotal_Sales(String total_Sales) {
        Total_Sales = total_Sales;
    }

    public String getTotal_Purchase() {
        return Total_Purchase;
    }

    public void setTotal_Purchase(String total_Purchase) {
        Total_Purchase = total_Purchase;
    }

    public String getTotal_Profit() {
        return Total_Profit;
    }

    public void setTotal_Profit(String total_Profit) {
        Total_Profit = total_Profit;
    }
}
