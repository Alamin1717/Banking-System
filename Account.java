package bankingapp;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        transactions.add(new Transaction("Account Created", balance));
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
