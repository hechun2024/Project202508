package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Currency") // Table name in the database
public class Currency {

    @Id
    @Column(name = "abbreviation") // Primary key: currency abbreviation (e.g., USD, EUR)
    private String abbreviation;

    private String name;

    private double rate_to_usd; // exchange rate against base currency

    public Currency() {
    }

    public Currency(String abbreviation, String name, double rate_to_usd) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rate_to_usd = rate_to_usd;
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

    public double getRate() {
        return rate_to_usd;
    }

    public void setRate(double rate_to_usd) {
        this.rate_to_usd = rate_to_usd;
    }
}

