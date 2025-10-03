package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDbJpaConnection {

    //static 表示这两个变量是 类级别的，整个程序只有一份，不会因为 new MariaDbJpaConnection() 而重复创建。
    //这就是单例模式的核心：共享唯一实例。
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    // Singleton instance 单例模式就是让一个类 在整个程序中只能有一个对象。
    public static EntityManager getInstance() {
        if (em == null) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}

/**
 * 这个类里体现单例模式的地方是：
 * 静态变量 (emf, em) → 全局唯一。
 * 静态方法 (getInstance()) → 提供全局访问入口。
 * 逻辑判断 (if (em == null)) → 确保只创建一次。
 * 👉 懒汉式单例（第一次用的时候才创建）
 */
