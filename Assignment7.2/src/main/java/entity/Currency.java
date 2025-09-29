//7.2 currrency converter connect to mariadb
package entity;


 // Represents a currency in the database. 映射数据库表的一行数据。

public class Currency {
    private int id;
    private String abbreviation;
    private String name;
    private double rate;

    public Currency(int id, String abbreviation, String name, double rate) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.name = name;
        this.rate = rate;
    }

    public int getId() { return id; }
    public String getAbbreviation() { return abbreviation; }
    public String getName() { return name; }
    public double getRate() { return rate; }

    @Override
    public String toString() {
        return abbreviation + " (" + name + ")";
    }
}

