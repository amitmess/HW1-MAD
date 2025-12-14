package com.bank;

public class PremiumAccount implements IAccount {

    private int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    @Override
    public void Deposit(double amount) {
    }

    @Override
    public double Withdraw(double amount) {
        return 0.0;
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
