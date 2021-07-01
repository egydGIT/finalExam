package hu.nive.ujratervezes.webshop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {
/*
    id int primary key (elsődleges kulcs)
    total int
    order_date datettime
    customer_name varchar

 */

    private int primary_key;
    private int total;
    private LocalDateTime order_date;
    private String customer_name;

    public Data(int primary_key, int total, LocalDateTime order_date, String customer_name) {
        this.primary_key = primary_key;
        this.total = total;
        this.order_date = order_date;
        this.customer_name = customer_name;
    }

    public Data(int total, LocalDateTime order_date, String customer_name) {
        this.total = total;
        this.order_date = order_date;
        this.customer_name = customer_name;
    }

    public Data() {
    }

    public List<String> getNamesSorted(List<Data> datas) {
        List<String> names = new ArrayList<>();
        for(Data data: datas) {
            names.add(data.getCustomer_name());
        }
        Collections.sort(names);
        return names;
    }

    public int getPrimary_key() {
        return primary_key;
    }

    public int getTotal() {
        return total;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    @Override
    public String toString() {
        return "\n" + "Data{" +
                "primary_key=" + primary_key +
                ", total=" + total +
                ", order_date=" + order_date +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}
