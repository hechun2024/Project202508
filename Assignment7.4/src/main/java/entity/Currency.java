package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    @Column(name = "id")
    private int id;

    @Column(name = "abbreviation", unique = true, nullable = false) // 唯一约束，不能重复
    private String abbreviation;

    @Column(name = "name")
    private String name;

    @Column(name = "rate_to_usd")
    private double rateToUsd;

    // 默认构造函数
    public Currency() {}

    // 构造函数（不需要传id，因为它是自增的）
    public Currency(String abbreviation, String name, double rateToUsd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUsd = rateToUsd;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return abbreviation + " (" + name + ") rate=" + rateToUsd;
    }
}
