package bank.accounts;

/**
 * @author Negin Mousavi
 */
public class SavingAccount extends Account {
    private static final double monthlyProfit = 0.1;

    public SavingAccount(int accountNumber, double balanceOpening, int year, int month, int day) {
        super(accountNumber, balanceOpening, year, month, day);
    }

    @Override
    public String toString() {
        return "Saving Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", balanceOpening=" + balanceOpening +
                ", myDate=" + myDate +
                ", monthlyProfit=" + monthlyProfit +
                '}';
    }

    public void calculateInterests() {
        balance += monthlyProfit * balance;
    }
}
