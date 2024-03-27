package ch24;

import java.util.Date;
import java.util.List;

public class TransactionData {
    private Date date;
    private int price;
    private int tax;
    private int fee;

    public TransactionData(Date date, int price, int tax, int fee){
        this.date=date;
        this.price=price;
        this.fee=fee;
        this.tax=tax;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
// tostring은 그냥 디버깅 용도

    @Override
    public String toString() {
        return "TransactionData{" +
                "date=" + date +
                ", price=" + price +
                ", tax=" + tax +
                ", fee=" + fee +
                '}';
    }
}
