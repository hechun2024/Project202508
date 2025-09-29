package dao;

import datasource.MariaDbConnection;
import entity.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for accessing currency data.
 */
public class CurrencyDao {

    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT * FROM Currency";

        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                currencies.add(new Currency(
                        rs.getInt("id"),
                        rs.getString("abbreviation"),
                        rs.getString("name"),
                        rs.getDouble("rate_to_usd")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error fetching currencies.");
            e.printStackTrace();
        }
        return currencies;
    }
}
