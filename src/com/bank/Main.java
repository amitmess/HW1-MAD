package com.bank;

import java.util.List;

public class Main {

    private static void printAccounts(String title, List<IAccount> list) {
        System.out.println("\n--- " + title + " (" + list.size() + ") ---");
        for (IAccount acc : list) {
            System.out.println(
                    acc.getClass().getSimpleName() +
                            " | #" + acc.GetAccountNumber() +
                            " | balance=" + acc.GetCurrentBalance()
            );
        }
    }

    public static void main(String[] args) {

        System.out.println("=== StandardAccount tests ===");

        IAccount a1 = new StandardAccount(1, -100);
        a1.Deposit(100);
        double w1 = a1.Withdraw(500);
        System.out.println("Test1 withdrawn=" + w1 + " balance=" + a1.GetCurrentBalance());
        // Expected: withdrawn=200.0, balance=-100.0

        IAccount a2 = new StandardAccount(2, 50);
        a2.Deposit(100);
        double w2 = a2.Withdraw(150);
        System.out.println("Test2 withdrawn=" + w2 + " balance=" + a2.GetCurrentBalance());
        // Expected: withdrawn=100.0, balance=0.0

        IAccount a3 = new StandardAccount(3, -200);
        a3.Deposit(200);
        double w3 = a3.Withdraw(50);
        System.out.println("Test3 withdrawn=" + w3 + " balance=" + a3.GetCurrentBalance());
        // Expected: withdrawn=50.0, balance=150.0

        IAccount a4 = new StandardAccount(4, -100);
        a4.Deposit(100);
        double w4 = a4.Withdraw(-10);
        System.out.println("Test4 withdrawn=" + w4 + " balance=" + a4.GetCurrentBalance());
        // Expected: withdrawn=0.0, balance=100.0


        System.out.println("\n=== BasicAccount tests ===");

        IAccount b1 = new BasicAccount(101, 50);
        b1.Deposit(200);
        double bw1 = b1.Withdraw(80);
        System.out.println("Basic T1 withdrawn=" + bw1 + " balance=" + b1.GetCurrentBalance());
        // Expected: withdrawn=50.0, balance=150.0

        IAccount b2 = new BasicAccount(102, 100);
        b2.Deposit(30);
        double bw2 = b2.Withdraw(80);
        System.out.println("Basic T2 withdrawn=" + bw2 + " balance=" + b2.GetCurrentBalance());
        // Expected: withdrawn=30.0, balance=0.0

        IAccount b3 = new BasicAccount(103, 100);
        b3.Deposit(90);
        double bw3 = b3.Withdraw(40);
        System.out.println("Basic T3 withdrawn=" + bw3 + " balance=" + b3.GetCurrentBalance());
        // Expected: withdrawn=40.0, balance=50.0


        System.out.println("\n=== PremiumAccount tests ===");

        IAccount p1 = new PremiumAccount(201);
        p1.Deposit(20);
        double pw1 = p1.Withdraw(100);
        System.out.println("Premium T1 withdrawn=" + pw1 + " balance=" + p1.GetCurrentBalance());
        // Expected: withdrawn=100.0, balance=-80.0

        IAccount p2 = new PremiumAccount(202);
        p2.Deposit(200);
        double pw2 = p2.Withdraw(50);
        System.out.println("Premium T2 withdrawn=" + pw2 + " balance=" + p2.GetCurrentBalance());
        // Expected: withdrawn=50.0, balance=150.0

        IAccount p3 = new PremiumAccount(203);
        double pw3a = p3.Withdraw(10);
        double pw3b = p3.Withdraw(15);
        System.out.println("Premium T3 withdrawn=" + (pw3a + pw3b) + " balance=" + p3.GetCurrentBalance());
        // Expected: withdrawn=25.0, balance=-25.0


        System.out.println("\n=== Bank scenario ===");

        Bank bank = new Bank();

        // Open accounts in bank (re-using some accounts from above)
        bank.OpenAccount(a1);
        bank.OpenAccount(b1);
        bank.OpenAccount(p1);

        IAccount bZero = new BasicAccount(500, 100);
        bank.OpenAccount(bZero);
        bank.CloseAccount(500); // צריך להיסגר כי balance = 0

        // Do a few more operations after opening in bank (to show filtering)
        // a1 currently at -100 from Test1, keep it in debt
        b1.Deposit(10);   // b1: 150 -> 160
        p1.Withdraw(10);  // p1: -80 -> -90

        // Print lists
        printAccounts("All accounts", bank.GetAllAccounts());
        printAccounts("Accounts in debt", bank.GetAllAccountsInDebt());
        printAccounts("Accounts with balance > 0", bank.GetAllAccountsWithBalance(0));

        // Close accounts demo
        System.out.println("\n=== CloseAccount demo ===");
        bank.CloseAccount(101); // b1 has positive balance -> should close
        bank.CloseAccount(1);   // a1 is in debt -> should NOT close + prints message
        bank.CloseAccount(999); // not found -> ignore

        printAccounts("All accounts after close attempts", bank.GetAllAccounts());

        System.out.println("\nAll tests finished.");
    }
}