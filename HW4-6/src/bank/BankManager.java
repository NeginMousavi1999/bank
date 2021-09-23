package bank;

import bank.accounts.Bank;

import java.util.Random;

/**
 * @author Negin Mousavi
 */
public class BankManager {
    Bank bank = new Bank();
    Random random = new Random();

    public void addAccount(String name, double balanceOpening, String fullDate, String typeAccount, double loanAmount, int loanTerm) {
        String date[] = fullDate.split(" ");
        int idOfCustomer = bank.searchInCustomerRepo(name);
        if (idOfCustomer == -1) {
            idOfCustomer = addNewCustomerAndReturnId(name);
            System.out.println("we did n't have you. now you are our new customer *.*");
        }
        bank.addNewAccount(idOfCustomer, generateAccountNumber(), balanceOpening, Integer.parseInt(date[0]),
                Integer.parseInt(date[1]), Integer.parseInt(date[2]), typeAccount, loanAmount, loanTerm);
        System.out.println("your account create successfully ^.^");
    }

    public int generateAccountNumber() {
        int randomNumber;
        do { //check if random num is unique or not
            randomNumber = random.nextInt(100000) + 100000;
            if (bank.isAccountExists(randomNumber) == -1) {
                break;
            }
        }while (true);

        return randomNumber;
    }

    public int addNewCustomerAndReturnId(String name) {
        return bank.addNewCustomer(name);
    }

    public void viewAccountsInfo(String name) {
        bank.ShowInfo(name);
    }

    public void withdraw(int accountNum, double amount, String fullDate) {
        int customerId = bank.isAccountExists(accountNum);
        if (customerId != -1) {
            String date[] = fullDate.split(" ");
            bank.withdraw(accountNum, customerId, amount, Integer.parseInt(date[0]),
                    Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            System.out.println("Done....");

        } else
            System.out.println("we have not account with this number id!");
    }

    public void deposit(int accountNum, double amount, String fullDate) {
        int customerId = bank.isAccountExists(accountNum);
        if (customerId != -1) {
            String date[] = fullDate.split(" ");
            bank.deposit(accountNum, customerId, amount, Integer.parseInt(date[0]),
                    Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            System.out.println("Done....");

        } else
            System.out.println("we have not account with this number id!");
    }

    public void viewAccountTransactions(int accountNum) {
        int customerId = bank.isAccountExists(accountNum);
        if (customerId != -1) {
            bank.viewTransactions(accountNum, customerId);
        } else
            System.out.println("we have not account with this number id!");
    }

    public void calculateInterests(int accountNum) {
        bank.calculateInterests(accountNum);
    }
}
