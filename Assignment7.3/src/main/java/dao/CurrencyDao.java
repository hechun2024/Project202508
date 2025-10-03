package dao;

import entity.Currency;
import datasource.MariaDbJpaConnection;
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
                "SELECT c FROM Currency c WHERE c.abbreviation = :abbr", Currency.class);
        query.setParameter("abbr", abbr);

        List<Currency> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    // Insert new currency
    public void addCurrency(Currency currency) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }
}
