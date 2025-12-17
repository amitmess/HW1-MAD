package com.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {

    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // OpenAccount: gets an account object and adds it to the bank accounts list.
    public void OpenAccount(IAccount account) {
        if (account == null) return;
        accounts.add(account);
    }

    // CloseAccount: if not found -> ignore. If found and balance >= 0 -> remove.
    // If balance < 0 -> print message and keep it.
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
    public List<IAccount> GetAllAccounts() {
        return new ArrayList<>(accounts); // return copy (safer)
    }

    // GetAllAccountsInDebt: returns a list of accounts with negative balance.
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> res = new ArrayList<>();
        for (IAccount acc : accounts) {
            if (acc.GetCurrentBalance() < 0) {
                res.add(acc);
            }
        }
        return res;
    }

    // GetAllAccountsWithBalance: returns a list of accounts with balance bigger than supplied double
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