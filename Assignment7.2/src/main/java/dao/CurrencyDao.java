package dao;

import datasource.MariaDbConnection;
import entity.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    // 获取所有货币
    public List<Currency> getAllCurrencies() throws SQLException {
        List<Currency> list = new ArrayList<>();
        String sql = "SELECT * FROM Currency";

        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Currency(
                        rs.getInt("id"),
                        rs.getString("abbreviation"),
                        rs.getString("name"),
                        rs.getDouble("rate_to_usd")
                ));
            }
        }
        return list;
    }

    // 获取某货币的汇率
    public double getExchangeRate(String abbreviation) throws SQLException {
        String sql = "SELECT rate_to_usd FROM Currency WHERE abbreviation = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, abbreviation);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("rate_to_usd");
            }
        }
        throw new SQLException("Currency not found: " + abbreviation);
    }
}
