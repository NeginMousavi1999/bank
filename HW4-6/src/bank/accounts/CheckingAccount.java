package bank.accounts;

/**
 * @author Negin Mousavi
 */
public class CheckingAccount extends Account {
    private static final double fees = 700;
    private static final double withdrawalRestrictions = 2000000;

    public CheckingAccount(int accountNumber, double balanceOpening, int year, int month, int day) {
        super(accountNumber, balanceOpening, year, month, day);
    }

    @Override
    public String toString() {
        return "Checking Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", balanceOpening=" + balanceOpening +
                ", myDate=" + myDate +
                ", fees=" + fees +
                ", withdrawalRestrictions=" + withdrawalRestrictions +
                '}';
    }

    @Override
    public boolean withdraw(double amountToWithdraw, int year, int month, int day) {
        if (amountToWithdraw < withdrawalRestrictions) {
            balance -= fees;
            return super.withdraw(amountToWithdraw, year, month, day);
        } else {
            System.out.println("limits!");
            return false;
        }
    }
}
