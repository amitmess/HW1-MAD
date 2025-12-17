package com.bank;

public class StandardAccount implements IAccount {

    private int accountNumber;
    private double creditLimit; // should be <= 0 (0 means no overdraft)
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;

        // credit limit must be negative; if positive treat as 0
        this.creditLimit = (creditLimit > 0) ? 0.0 : creditLimit;

        this.balance = 0.0;
    }

    @Override
    public void Deposit(double amount) {
        // Not specified in the assignment; safe behavior: ignore non-positive deposits
        if (amount <= 0) return;
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        // Not specified; safe behavior: ignore non-positive withdrawals
        if (amount <= 0) return 0.0;

        // Maximum you can withdraw without going below creditLimit:
        // newBalance >= creditLimit  =>  balance - withdrawn >= creditLimit
        // => withdrawn <= balance - creditLimit
        double maxAllowed = balance - creditLimit;

        if (maxAllowed <= 0) {
            return 0.0; // already at/below limit (shouldn't normally happen in StandardAccount)
        }

        double actual = Math.min(amount, maxAllowed);
        balance -= actual;
        return actual;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}