-- USE currencydb;

-- 1. Retrieve all the currencies
SELECT * FROM Currency;

-- 2. Retrieve the currency with abbreviation EUR
SELECT * FROM Currency WHERE abbreviation = 'EUR';

-- 3. Retrieve the number of currencies
SELECT COUNT(*) AS total_currencies FROM Currency;

-- 4. Retrieve the currency with the highest exchange rate
SELECT * FROM Currency ORDER BY rate_to_usd DESC LIMIT 1;

-- SELECT USER(), CURRENT_USER();

