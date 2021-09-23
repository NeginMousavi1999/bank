package bank.accounts;

import bank.Customer;

/**
 * @author Negin Mousavi
 */
public class Bank {
    private Customer[] customers = new Customer[100];
    private int indexOfCustomer = 0;

    public void addNewAccount(int id, int accountNumber, double balanceOpening, int year, int month, int day, String typeAccount, double loanAmount, int loanTerm) {
        switch (typeAccount) {
            case "c":
                customers[id].addCheckingAccount(accountNumber, balanceOpening, year, month, day);
                break;

            case "l":
                customers[id].addLoanAccount(accountNumber, balanceOpening, year, month, day, loanAmount, loanTerm);
                break;

            case "s":
                customers[id].addSavingAccount(accountNumber, balanceOpening, year, month, day);
                break;
        }
    }

    public int addNewCustomer(String name) {
        if (indexOfCustomer < 100) {
            customers[indexOfCustomer] = new Customer(indexOfCustomer, name);
            indexOfCustomer++;
            return indexOfCustomer - 1;
        }
        return -1;
    }

    public int searchInCustomerRepo(String name) {
        for (Customer customer : customers
        ) {
            if (customer == null)
                return -1;
            if (customer.getName().equals(name))
                return customer.getId();
        }
        return -1;
    }

    public void ShowInfo(String name) {

        for (Customer customer : customers
        ) {
            if (customer == null) {
                System.out.println("there is no customer here!");
                return;
            }
            if (customer.getName().equals(name)) {
                int count = 0;
                for (Account account : customer.getAccounts()
                ) {
                    if (account == null && count == 0) {
                        System.out.println("no accounts for this customer");
                        return;
                    }
                    if (account == null)
                        return;

                    System.out.println(account.toString());
                    count++;
                }
            }
        }
        System.out.println("we have n't this customer!");
    }

    public int isAccountExists(int accountNum) {
        for (Customer customer : customers
        ) {
            if (customer == null)
                return -1;
            if (customer.hasThisAccountNumber(accountNum))
                return customer.getId();
        }
        return -1;
    }

    public void withdraw(int accountNum, int customerId, double amount, int year, int month, int day) {
        customers[customerId].withdraw(accountNum, amount, year, month, day);
    }

    public void deposit(int accountNum, int customerId, double amount, int year, int month, int day) {
        customers[customerId].deposit(accountNum, amount, year, month, day);
    }

    public void viewTransactions(int accountNum, int customerId) {
        customers[customerId].viewTransactions(accountNum);
    }

    public void calculateInterests(int accountNum) {
        for (Customer customer : customers
        ) {
            if (customer == null)
                return;
            if (customer.hasThisAccountNumber(accountNum))
                customer.isAccountLoanOrSavingAndCalculateInterests(accountNum);
        }
    }
}
