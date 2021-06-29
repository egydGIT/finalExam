package hu.nive.ujratervezes.webshop;

import java.time.LocalDate;

public class DataBase {
/*
    id int primary key (elsődleges kulcs)
    total int
    order_date datettime
    customer_name varchar

 */

    private int primary_key;
    private int total;
    private LocalDate order_date;
    private String customer_name;

    public DataBase(int primary_key, int total, LocalDate order_date, String customer_name) {
        this.primary_key = primary_key;
        this.total = total;
        this.order_date = order_date;
        this.customer_name = customer_name;
    }

    public int getPrimary_key() {
        return primary_key;
    }

    public int getTotal() {
        return total;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }
}
