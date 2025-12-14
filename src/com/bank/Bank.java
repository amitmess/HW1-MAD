package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void OpenAccount(IAccount account) {
    }

    public void CloseAccount(int accountNumber) {
    }

    public List<IAccount> GetAllAccounts() {
        return null;
    }

    public List<IAccount> GetAllAccountsInDebt() {
        return null;
    }

    public List<IAccount> GetAllAccountsWithBalance(double minBalance) {
        return null;
    }
}
