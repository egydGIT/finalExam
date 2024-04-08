package hu.nive.ujratervezes.webshop;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class WebshopServiceDao {

    private DataSource dataSource;

    public WebshopServiceDao(DataSource dataSource) {              // dependency injection
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

    // after exam:
    public List<Data> getValuableCustomersEveryData() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from orders where total > 1000");
        ) {
            List<Data> datas = new ArrayList<>();
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Data data = new Data(
                            rs.getInt("id"),
                            rs.getInt("total"),
                            rs.getTimestamp("order_date").toLocalDateTime(),
                            rs.getString("customer_name"));
                    datas.add(data);
                }
                return datas;
            }
            catch (SQLException se) {
                throw new IllegalArgumentException("Wrong statement.", se);
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("Can not connect", se);
        }
    }


}
