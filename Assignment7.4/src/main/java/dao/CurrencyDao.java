//7.4 数据访问层（操作数据库）
package dao;

import datasource.MariaDbJpaConnection;
import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CurrencyDao {

    // Retrieve all currencies
    public List<Currency> getAllCurrencies() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
    }

    // Retrieve a currency by abbreviation (NOT primary key id)
    public Currency find(String abbr) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        TypedQuery<Currency> query = em.createQuery(
                "SELECT c FROM Currency c WHERE c.abbreviation = :abbr", Currency.class);  // :abbr 是一个自己起的参数名
        query.setParameter("abbr", abbr);

        List<Currency> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);  //三元运算符 (ternary operator)：如果查询结果为空，返回 null；否则返回第一条记录
    }

    // Insert new currency
    public void addCurrency(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();  //开启事务（数据库的一个操作单元，要么全部成功，要么全部回滚）
        em.persist(currency);
        em.getTransaction().commit();

    }
}
