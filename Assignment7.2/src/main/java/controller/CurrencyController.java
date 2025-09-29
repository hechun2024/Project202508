package controller;

import model.CurrencyModel;

import java.sql.SQLException;

public class CurrencyController {
    private final CurrencyModel model = new CurrencyModel();

    // 计算换算金额
    public double convert(String from, String to, double amount) throws SQLException {
        double rateFrom = model.getExchangeRate(from);
        double rateTo = model.getExchangeRate(to);
        return amount * (rateTo / rateFrom);
    }

    public CurrencyModel getModel() {
        return model;
    }
}
