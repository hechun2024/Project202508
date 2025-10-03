package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;   // 转换金额
    private double result;   // 转换结果

    // 多对一：多个交易可以涉及同一个货币
    @ManyToOne
    @JoinColumn(name = "from_currency", referencedColumnName = "id")
    private Currency fromCurrency;

    @ManyToOne
    @JoinColumn(name = "to_currency", referencedColumnName = "id")
    private Currency toCurrency;

    // 构造函数
    public Transaction() {
    }

    public Transaction(double amount, double result, Currency fromCurrency, Currency toCurrency) {
        this.amount = amount;
        this.result = result;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    // toString() 方便调试时直接看到货币缩写
    @Override
    public String toString() {
        return String.format("Transaction: %.2f %s -> %.2f %s",
                amount,
                fromCurrency.getAbbreviation(),
                result,
                toCurrency.getAbbreviation());
    }
}
