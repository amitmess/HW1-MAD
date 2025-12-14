package com.bank;

public class StandardAccount implements IAccount {

    private int accountNumber;
    private double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.creditLimit = creditLimit;
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
