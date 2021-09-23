package bank.accounts;


import bank.MyDate;

/**
 * @author Negin Mousavi
 */
public class Account {
    protected int accountNumber;
    protected double balance;
    protected double balanceOpening;
    protected MyDate myDate;
    protected Transactions[] transactions = new Transactions[100];
    protected int indexOfTransactions = 0;

    public Account(int accountNumber, double balanceOpening, int year, int month, int day) {
        this.accountNumber = accountNumber;
        this.balance = balanceOpening; //for the first time they are equal
        this.balanceOpening = balanceOpening;
        this.myDate = new MyDate(year, month, day);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", balanceOpening=" + balanceOpening +
                ", myDate=" + myDate +
                '}';
    }

    public boolean withdraw(double amountToWithdraw, int year, int month, int day) {
        if (balance > amountToWithdraw) {
            balance -= amountToWithdraw;
            transactions[indexOfTransactions++] = new Transactions(TypeOfTransactions.WITHDRAW, new MyDate(year, month, day), amountToWithdraw);
            return true;
        } else
            return false;
    }

    public boolean deposit(double amountToDeposit, int year, int month, int day) {
        balance += amountToDeposit;
        transactions[indexOfTransactions++] = new Transactions(TypeOfTransactions.DEPOSIT, new MyDate(year, month, day), amountToDeposit);
        return true;
    }

    public void viewTransactions() {
        int count = 0;
        for (Transactions transaction : transactions
        ) {
            if (transaction == null)
                return;
            if (transaction == null && count == 0) {
                System.out.println("there is no transaction for this account");
                return;
            }
            System.out.println(transaction.toString());
            count++;
        }
    }
}
