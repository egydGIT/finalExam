package hu.nive.ujratervezes.webshop;

import javax.sql.DataSource;
import java.sql.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class WebshopService {

    DataSource dataSource;

    public WebshopService(DataSource dataSource) {              // dependency injection
        this.dataSource = dataSource;
    }

    public List<String> getValuableCustomers() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select customer_name from orders where total > 1000")
        ) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("customer_name");
                names.add(name);
            }
            Collections.sort(names, Collator.getInstance(new Locale("hu", "HU")));
            return names;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by querry ", sqle);
        }

    }

    /*
    Gloria Hyatt
    Clara Spinka
    Stacy Doyle Jr.
    Gloria Hyatt
     */

}
