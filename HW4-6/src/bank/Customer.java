package bank;

import bank.accounts.Account;
import bank.accounts.CheckingAccount;
import bank.accounts.LoanAccount;
import bank.accounts.SavingAccount;

import java.util.Arrays;

/**
 * @author Negin Mousavi
 */
public class Customer {
    private int id;
    private String name;
    private Account[] accounts = new Account[100];
    private int indexOfAccounts = 0;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                ", indexOfAccounts=" + indexOfAccounts +
                '}';
    }

    public void addSavingAccount(int accountNumber, double balanceOpening, int year, int month, int day) {
        accounts[indexOfAccounts++] = new SavingAccount(accountNumber, balanceOpening, year, month, day);
    }

    public void addLoanAccount(int accountNumber, double balanceOpening, int year, int month, int day, double loanAmount, int loanTerm) {
        accounts[indexOfAccounts++] = new LoanAccount(accountNumber, balanceOpening, loanAmount, loanTerm, year, month, day);
    }

    public void addCheckingAccount(int accountNumber, double balanceOpening, int year, int month, int day) {
        accounts[indexOfAccounts++] = new CheckingAccount(accountNumber, balanceOpening, year, month, day);
    }

    public boolean hasThisAccountNumber(int accountNumber) {
        for (Account account : accounts
        ) {
            if (account == null)
                return false;
            if (accountNumber == account.getAccountNumber())
                return true;
        }
        return false;
    }

    public void withdraw(int accountNum, double amountToWithdraw, int year, int month, int day) {
        for (Account account : accounts
        ) {
            if (account == null)
                return;
            if (accountNum == account.getAccountNumber())
                account.withdraw(amountToWithdraw, year, month, day);
        }
        System.out.println("balance is not enough!");
    }

    public void deposit(int accountNum, double amountToDeposit, int year, int month, int day) {
        for (Account account : accounts
        ) {
            if (account == null)
                return;
            if (accountNum == account.getAccountNumber())
                account.deposit(amountToDeposit, year, month, day);
        }
    }

    public void viewTransactions(int accountNum) {
        for (Account account : accounts
        ) {
            if (account == null)
                return;
            if (accountNum == account.getAccountNumber())
                account.viewTransactions();
        }
    }

    public void isAccountLoanOrSavingAndCalculateInterests(int accountNum) {
        for (Account account : accounts
        ) {
            if (account == null)
                return;
            if (hasThisAccountNumber(accountNum)) {
                if (accountNum == account.getAccountNumber()) {
                    if (account.getClass().equals(SavingAccount.class)) {
                        SavingAccount savingAccount = (SavingAccount) account;
                        savingAccount.calculateInterests();
                        System.out.println(savingAccount.getBalance());
                    } else if (account.getClass().equals(LoanAccount.class)) {
                        LoanAccount loanAccount = (LoanAccount) account;
                        loanAccount.calculateInterests();
                    } else
                        System.out.println("your account is checking and it has not interest");
                }
            }
        }
    }
}
