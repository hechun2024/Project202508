package dao;

import datasource.MariaDbJpaConnection;
import entity.Transaction;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TransactionDao {

    // 添加一条交易记录
    public void addTransaction(Transaction transaction) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
    }

    // 查询所有交易记录
    public List<Transaction> getAllTransactions() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.createQuery("SELECT t FROM Transaction t", Transaction.class)
                .getResultList();
    }
}
