-- 1. Drop the previous version of the database, if it exists
DROP DATABASE IF EXISTS currencydb;

-- 2. Create the database
CREATE DATABASE currencydb;

-- Use the new database
USE currencydb;

-- 3. Create a table for storing Currency objects
CREATE TABLE Currency (
                          id INT NOT NULL AUTO_INCREMENT,
                          abbreviation VARCHAR(10) NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          rate_to_usd DECIMAL(10, 4) NOT NULL,
                          PRIMARY KEY (id)
);

-- 4. Insert at least eight currencies with up-to-date exchange rates (example rates, adjust if needed)
INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES
                                                           ('USD', 'US Dollar', 1.0000),
                                                           ('EUR', 'Euro', 0.9500),
                                                           ('GBP', 'British Pound', 0.8200),
                                                           ('JPY', 'Japanese Yen', 150.2000),
                                                           ('CNY', 'Chinese Yuan', 7.3000),
                                                           ('AUD', 'Australian Dollar', 1.5700),
                                                           ('CAD', 'Canadian Dollar', 1.3600),
                                                           ('CHF', 'Swiss Franc', 0.9100);


-- 5. Drop the user account appuser, if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- 6. Create the user account appuser
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

-- 7. Grant only the needed privileges (SELECT, INSERT, UPDATE, DELETE)
GRANT SELECT, INSERT, UPDATE, DELETE ON currencydb.* TO 'appuser'@'localhost';
