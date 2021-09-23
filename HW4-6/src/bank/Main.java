package bank;

import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankManager bankManager = new BankManager();

        int managerOption;
        options:
        do {
            System.out.println("Choose:\n" +
                    "1. Add new account \n" +
                    "2. View accounts    \n" +
                    "3. Withdraw \n" +
                    "4. Deposit \n" +
                    "5. Calculate interests \n" +
                    "6. View Transactions \n" +
                    "7. Exit");
            managerOption = scanner.nextInt();
            switch (managerOption) {
                case 1:
                    System.out.print("what kind of account do you want to open? 'c' for CheckingAccount," +
                            " 's' for SavingAccount, 'l' for LoanAccount: ");
                    String typeAccount = scanner.next();

                    System.out.println("Enter the information that we need:");
                    scanner.nextLine();
                    System.out.print("name of customer: ");
                    String nameOfNewCustomer = scanner.nextLine();

                    System.out.print("amount of opening account: ");
                    double amount = scanner.nextDouble();

                    scanner.nextLine();
                    System.out.print("day, month, year. split them with a space: ");
                    String fullDate = scanner.nextLine();

                    double loanAmount = 0;
                    int loanTerm = 0;

                    if (typeAccount.equals("l")) {
                        System.out.print("Enter amount of loan: ");
                        loanAmount = scanner.nextDouble();

                        System.out.print("Enter count of mouth that you will return it: ");
                        loanTerm = scanner.nextInt();
                    }
                    bankManager.addAccount(nameOfNewCustomer, amount, fullDate, typeAccount, loanAmount, loanTerm);
                    printStar();
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Enter the name of your customer: ");
                    String name = scanner.nextLine();
                    bankManager.viewAccountsInfo(name);
                    printStar();
                    break;

                case 3:
                    System.out.println("Enter the information that we need:");
                    scanner.nextLine();

                    System.out.print("the number of account : ");
                    int accountNumber = scanner.nextInt();

                    System.out.print("amount of withdraw: ");
                    amount = scanner.nextDouble();

                    scanner.nextLine();
                    System.out.print("day, month, year. split them with a space: ");
                    fullDate = scanner.nextLine();
                    bankManager.withdraw(accountNumber, amount, fullDate);
                    printStar();
                    break;

                case 4:
                    System.out.println("Enter the information that we need:");
                    scanner.nextLine();

                    System.out.print("the number of account : ");
                    accountNumber = scanner.nextInt();

                    System.out.print("amount of deposit: ");
                    amount = scanner.nextDouble();

                    scanner.nextLine();
                    System.out.print("day, month, year. split them with a space: ");
                    fullDate = scanner.nextLine();
                    bankManager.deposit(accountNumber, amount, fullDate);
                    printStar();
                    break;

                case 5:
                    System.out.println("Enter the information that we need:");
                    scanner.nextLine();

                    System.out.print("the number of account : ");
                    accountNumber = scanner.nextInt();
                    bankManager.calculateInterests(accountNumber);
                    break;

                case 6:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    bankManager.viewAccountTransactions(accountNumber);
                    printStar();
                    break;

                case 7:
                    System.out.println("bye bye :))) ");
                    printStar();
                    break options;

                default:
                    printInvalidInput();
                    break;
            }
        } while (true);
    }

    public static void printInvalidInput() {
        System.out.println("invalid input");
    }

    public static void printStar() {
        System.out.println("**********************************************************");
    }
}
