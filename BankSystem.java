package bankingapp;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<String, Account> accounts;

    public BankSystem() {
        accounts = new HashMap<>();
    }

    public Account createAccount(String name, String accountNumber, double initialDeposit) {
        Account acc = new Account(name, accountNumber, initialDeposit);
        accounts.put(accountNumber, acc);
        return acc;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
