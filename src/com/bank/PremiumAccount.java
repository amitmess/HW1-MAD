package com.bank;

public class PremiumAccount implements IAccount {

    private final int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
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

        balance -= amount;     // can go negative freely
        return amount;
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