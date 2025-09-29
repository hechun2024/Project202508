package model;

import dao.CurrencyDao;
import entity.Currency;
import java.sql.SQLException;
import java.util.List;

public class CurrencyModel {
    private final CurrencyDao currencyDao = new CurrencyDao();

    public List<Currency> getCurrencies() throws SQLException {
        return currencyDao.getAllCurrencies();
    }

    public double getExchangeRate(String abbreviation) throws SQLException {
        return currencyDao.getExchangeRate(abbreviation);
    }
}
