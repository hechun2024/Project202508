package entity; //实体类（对应数据库表里的货币）

import jakarta.persistence.*;

// 每一个 Currency 对象都代表表中的一行记录。

@Entity                                // 声明这是一个 JPA 实体类
@Table(name = "Currency")              // 指定对应的数据库表名
public class Currency {

    @Id                                // 主键（Primary Key）
    @Column(name = "abbreviation")     // 数据库列名是 abbreviation
    private String abbreviation;       // 货币缩写（例如 USD, EUR）

    @Column(name = "name")             // 显式写上列名，避免 SQL 保留字冲突
    private String name;               // 货币全称（例如 US Dollar）

    @Column(name = "rate_to_usd")      // 数据库列名是 rate_to_usd
    private double rateToUsd;          // Java 命名改为驼峰更规范（rateToUsd）

    // ---------------- 构造方法 ----------------

    // JPA 要求必须有一个无参构造函数
    public Currency() {}

    // 有参构造函数，方便自己创建对象时使用
    public Currency(String abbreviation, String name, double rateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUsd = rateToUsd;
    }

    // ---------------- Getter & Setter ----------------

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRateToUsd() {
        return rateToUsd;
    }

    public void setRateToUsd(double rateToUsd) {
        this.rateToUsd = rateToUsd;
    }

    // ---------------- 调试方法 ----------------

    @Override
    public String toString() {
        // 方便打印对象时查看数据内容
        return abbreviation + " - " + name + " (Rate to USD: " + rateToUsd + ")";
    }
}
