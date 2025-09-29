//7.2 currrency converter connect to mariadb
package model;

import dao.CurrencyDao;
import entity.Currency;

import java.util.List;

//会调用 dao，获取一堆 entity，然后提供给 view 使用。
 // Model layer: provides currency data to the View.

public class CurrencyModel {
    private CurrencyDao dao = new CurrencyDao();

    public List<Currency> getCurrencies() {
        return dao.getAllCurrencies();
    }
}
