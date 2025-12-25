package com.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank implements IBank {

    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // OpenAccount: adds account only if accountNumber doesn't already exist
    @Override
    public void OpenAccount(IAccount account) {
        if (account == null) return;

        int newNum = account.GetAccountNumber();
        for (IAccount acc : accounts) {
            if (acc.GetAccountNumber() == newNum) {
                return; // duplicate -> ignore
            }
        }

        accounts.add(account);
    }

    // CloseAccount: if not found -> ignore. If found and balance >= 0 -> remove.
    // If balance < 0 -> print message and keep it.
    @Override
    public void CloseAccount(int accountNumber) {
        Iterator<IAccount> it = accounts.iterator();
        while (it.hasNext()) {
            IAccount acc = it.next();
            if (acc.GetAccountNumber() == accountNumber) {
                if (acc.GetCurrentBalance() >= 0) {
                    it.remove();
                } else {
                    System.out.println("Account " + accountNumber + " was not closed due to debt.");
                }
                return; // found -> stop
            }
        }
        // not found -> ignore
    }

    // GetAllAccounts: returns all of the accounts in the bank as List
    @Override
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts); // return copy (safer)
    }

    // GetAllAccountsInDebt: returns a list of accounts with negative balance.
    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> res = new ArrayList<>();
        for (IAccount acc : accounts) {
            if (acc.GetCurrentBalance() < 0) {
                res.add(acc);
            }
        }
        return res;
    }

    // GetAllAccountsWithBalance: returns accounts with balance strictly greater than minBalance
    @Override
    public List<IAccount> GetAllAccountsWithBalance(double minBalance) {
        List<IAccount> res = new ArrayList<>();
        for (IAccount acc : accounts) {
            if (acc.GetCurrentBalance() > minBalance) {
                res.add(acc);
            }
        }
        return res;
    }
}