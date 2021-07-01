package hu.nive.ujratervezes.webshop;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

public class WebShopMain {

    // after exam

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException throwables) {
            throw new IllegalStateException("Can not connect", throwables);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        WebshopServiceDao webshopServiceDao = new WebshopServiceDao(dataSource);

        List<String> names = webshopServiceDao.getValuableCustomers();
        System.out.println(names);

        List<Data> datas = webshopServiceDao.getValuableCustomersEveryData();
        System.out.println(datas);


        Data data = new Data();

        List<String> namesFromData = data.getNamesSorted(datas);
        System.out.println(namesFromData);

    }

    /*
    [Clara Spinka, Gloria Hyatt, Gloria Hyatt, Stacy Doyle Jr.]
     */

    /*
    [
    Data{primary_key=3, total=1374, order_date=2021-01-24T13:52:07, customer_name='Gloria Hyatt'},
    Data{primary_key=4, total=1385, order_date=2021-01-22T03:40:41, customer_name='Clara Spinka'},
    Data{primary_key=10, total=1141, order_date=2021-01-19T20:56:49, customer_name='Stacy Doyle Jr.'},
    Data{primary_key=12, total=1023, order_date=2021-01-24T03:24:39, customer_name='Gloria Hyatt'}]
     */

    /*
    [Clara Spinka, Gloria Hyatt, Gloria Hyatt, Stacy Doyle Jr.]
     */

}
