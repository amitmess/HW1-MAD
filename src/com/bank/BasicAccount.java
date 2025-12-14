package com.bank;

public class BasicAccount implements IAccount {

    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
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
