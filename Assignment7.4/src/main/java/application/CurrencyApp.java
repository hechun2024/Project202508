//7.4 应用程序入口
package application;

import datasource.MariaDbJpaConnection;
import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javafx.application.Application;
import ui.CurrencyUI;

public class CurrencyApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = MariaDbJpaConnection.getInstance().getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

// 插入初始货币数据
        em.persist(new Currency("USD", "US Dollar", 1.0));
        em.persist(new Currency("EUR", "Euro", 0.85));
        em.persist(new Currency("GBP", "British Pound", 0.82));
        em.persist(new Currency("JPY", "Japanese Yen", 150.2));
        em.persist(new Currency("CNY", "Chinese Yuan", 7.1));
        em.persist(new Currency("AUD", "Australian Dollar", 1.57));
        em.persist(new Currency("CAD", "Canadian Dollar", 1.36));
        em.persist(new Currency("CHF", "Swiss Franc", 0.91));

        em.getTransaction().commit();
        em.close();

        Application.launch(CurrencyUI.class, args);
    }
}
