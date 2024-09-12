import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class manageTransactions {

    private Accounts account;  // Hold the account object
    private List<Accounts> accountsList;  // Hold the list of all accounts
    private String filePath;  // File path to store account data

    // Constructor to pass the account, response, and the file path
    public manageTransactions(Accounts account, int response, List<Accounts> accountsList, String filePath) {
        this.account = account;
        this.accountsList = accountsList;
        this.filePath = filePath;

        if (response == 1) {
            handleSavings();
        } else if (response == 2) {
            handleCurrent();
        } else if (response == 3) {
            displayBalance();
        }
    }

    // Method to handle savings account transactions (withdrawal or deposit)
    private void handleSavings() {
        System.out.println("Savings Account:\n1. Withdrawal\n2. Deposit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter amount to withdraw from your savings account:");
            int amount = scanner.nextInt();
            if (checkMoney(amount)) {
                account.setBalance(account.getBalance() - amount);  // Deduct balance
                System.out.println(amount + "$ has been debited from your savings. New balance: " + account.getBalance() + "$");
                updateAccountsFile();  // Update the file with the new balance
            } else {
                System.out.println("Insufficient balance.");
            }
        } else if (choice == 2) {
            System.out.println("Enter amount to deposit in your savings account:");
            int amount = scanner.nextInt();
            account.setBalance(account.getBalance() + amount);  // Add to balance
            System.out.println(amount + "$ has been credited to your savings. New balance: " + account.getBalance() + "$");
            updateAccountsFile();  // Update the file with the new balance
        }
    }

    // Method to handle current account transactions (withdrawal or deposit)
    private void handleCurrent() {
        System.out.println("Current Account:\n1. Withdrawal\n2. Deposit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter amount to withdraw from your current account:");
            int amount = scanner.nextInt();
            if (checkMoney(amount)) {
                account.setBalance(account.getBalance() - amount);  // Deduct balance
                System.out.println(amount + "$ has been debited from your current account. New balance: " + account.getBalance() + "$");
                updateAccountsFile();  // Update the file with the new balance
            } else {
                System.out.println("Insufficient balance.");
            }
        } else if (choice == 2) {
            System.out.println("Enter amount to deposit in your current account:");
            int amount = scanner.nextInt();
            account.setBalance(account.getBalance() + amount);  // Add to balance
            System.out.println(amount + "$ has been credited to your current account. New balance: " + account.getBalance() + "$");
            updateAccountsFile();  // Update the file with the new balance
        }
    }

    // Method to display current balance
    private void displayBalance() {
        System.out.println("Your current balance is: " + account.getBalance() + "$");
    }

    // Check if the account has enough balance for withdrawal
    public boolean checkMoney(int input) {
        return input <= account.getBalance();
    }

    // Method to update the txt file after a transaction
    public void updateAccountsFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Accounts acc : accountsList) {
                // Update the file by writing each account's updated balance
                writer.write(acc.getUsername() + "," +
                        acc.getAccountNumber() + "," +
                        acc.getPassword() + "," +
                        acc.getBalance() + "\n");
            }
            System.out.println("Account balance updated in the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating the file.");
            e.printStackTrace();
        }
    }
}
