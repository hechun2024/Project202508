// task 1

public class BankAccount {
    // Static variable: shared across all BankAccount objects
    private static int totalAccounts = 0;

    // Instance variables: each account has its own accountNumber and balance
    private int accountNumber;
    private double balance;

    // Constructor: creates a new account with initial balance
    public BankAccount(double initialBalance) {
        this.accountNumber = ++totalAccounts; // increase account count and assign as accountNumber
        this.balance = initialBalance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Static method: belongs to the class, not instances
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());
        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
