# HW1 – Mini Banking System (Java)

## Overview
This project implements a simple banking system in Java as part of HW1.
It includes three account types (`StandardAccount`, `BasicAccount`, `PremiumAccount`) that implement a common interface (`IAccount`),
and a bank implementation (`Bank`) that manages accounts through the `IBank` interface.

The project was tested locally using the provided lecturer demo logic (depositing/withdrawing across account types, listing accounts in debt, closing accounts, etc.)
and additional scenarios in `Main`.

---

## Project Structure
- `src/com/bank/IAccount.java` – Interface for all account types.
- `src/com/bank/StandardAccount.java` – Standard account with a credit limit (overdraft limited by `creditLimit`).
- `src/com/bank/BasicAccount.java` – Basic account with **no overdraft** and a per-withdrawal limit.
- `src/com/bank/PremiumAccount.java` – Premium account with **no overdraft limit** (can always withdraw full amount).
- `src/com/bank/IBank.java` – Interface for bank operations.
- `src/com/bank/Bank.java` – Bank implementation holding a list of accounts and providing filters & close logic.
- `src/com/bank/Main.java` – Test & usage scenario (prints expected behaviors).

> Note: All classes are in the package `com.bank`, so the folder structure and `package com.bank;` declarations must match.

---

## Implemented Requirements

### IAccount
Each account supports:
- `Deposit(double amount)`
- `Withdraw(double amount)` → returns the **actual amount withdrawn**
- `GetCurrentBalance()`
- `GetAccountNumber()`

### StandardAccount
- Supports overdraft **down to** `creditLimit` (typically negative).
- If `creditLimit` is positive, it is treated as `0` (no overdraft).
- `Withdraw(amount)` returns `min(amount, balance - creditLimit)` and updates balance accordingly.

### BasicAccount
- **No overdraft** (cannot go below 0).
- Has a per-operation `withdrawalLimit`.
- `Withdraw(amount)` returns `min(amount, balance, withdrawalLimit)`.

### PremiumAccount
- No overdraft limit.
- `Withdraw(amount)` always returns `amount` and updates balance (`balance -= amount`).

### IBank / Bank
Bank supports:
- `OpenAccount(IAccount account)` – adds account to the bank.
- `CloseAccount(int accountNumber)` – closes only if balance >= 0, otherwise prints a message and keeps account.
- `GetAllAccounts()`
- `GetAllAccountsInDebt()` – balance < 0
- `GetAllAccountsWithBalance(double minBalance)` – balance > minBalance

Optional improvement included:
- Prevent opening duplicate accounts with the same account number (ignore duplicates in `OpenAccount`).

---

## How to Run

### Option A: IntelliJ IDEA
1. Open the project in IntelliJ.
2. Make sure the SDK is set (Java 17+ recommended).
3. Run `Main.java`.

### Option B: Command Line
From the project root (adjust paths if needed):
javac -d out src/com/bank/*.java
java -cp out com.bank.Main

---

## Main Demo / Output

Main.java includes:

Basic tests for each account type (Standard/Basic/Premium) with printed expected results.

A bank scenario:

Open several accounts in Bank

Perform deposits/withdrawals

Print:

All accounts

Accounts in debt

Accounts with balance above a threshold

Demonstrate CloseAccount behavior (close allowed only when balance >= 0)

## Notes

The program prints results to the console to demonstrate correctness.

## Team:
Amit Messil
Dan Madpis
Amit Mane
Ran Efroni

