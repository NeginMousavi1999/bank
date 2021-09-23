package bank.accounts;

/**
 * @author Negin Mousavi
 */
public class LoanAccount extends Account {
    private final double loanAmount;
    private static final double interestRate = 0.1;
    private final int loanTerm;
    private static final double monthlyProfit = 0.1;

    public LoanAccount(int accountNumber, double balanceOpening, double loanAmount, int loanTerm, int year, int month, int day) {
        super(accountNumber, balanceOpening, year, month, day);
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
    }

    @Override
    public String toString() {
        return "Loan Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", balanceOpening=" + balanceOpening +
                ", myDate=" + myDate +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", loanTerm=" + loanTerm +
                ", monthlyProfit=" + monthlyProfit +
                '}';
    }

    public void calculateInterests() {
        balance += monthlyProfit * balance;
    }
}
