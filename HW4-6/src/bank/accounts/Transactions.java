package bank.accounts;

import bank.MyDate;

/**
 * @author Negin Mousavi
 */
public class Transactions {
    private TypeOfTransactions type;
    private MyDate date;
    private double amount;

    public Transactions(TypeOfTransactions type, MyDate date, double amount) {
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    public TypeOfTransactions getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "type=" + type +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
