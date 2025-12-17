package com.bank;

public class BasicAccount implements IAccount {

    private final int accountNumber;
    private final double withdrawalLimit; // per operation, expected positive
    private double balance;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = (withdrawalLimit < 0) ? 0.0 : withdrawalLimit;
        this.balance = 0.0;
    }

    @Override
    public void Deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (amount <= 0) return 0.0;

        // Can't go below 0, and can't exceed withdrawalLimit per operation
        double actual = Math.min(amount, Math.min(balance, withdrawalLimit));
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