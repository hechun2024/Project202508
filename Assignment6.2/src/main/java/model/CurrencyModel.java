package model;

import java.util.ArrayList;
import java.util.List;

// 这是模型, 用来存储和提供所有的货币数据
public class CurrencyModel {
    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();

        // 这里暂时硬编码几种货币 (USD为基准)
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.92));
        currencies.add(new Currency("GBP", "British Pound", 0.79));
        currencies.add(new Currency("JPY", "Japanese Yen", 147.0));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }
}
