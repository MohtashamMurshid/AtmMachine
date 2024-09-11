import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class displayAmount {

    private Accounts account;  // Hold the account object
    private List<Accounts> accountsList;  // Hold the list of all accounts
    private String filePath;  // File path to store account data

    // Constructor to pass the account, response, and the file path
    public displayAmount(Accounts account, int response, List<Accounts> accountsList, String filePath) {
        this.account = account;
        this.accountsList = accountsList;
        this.filePath = filePath;

        if (response == 1) {
            handleSavingsWithdrawal();
        } else if (response == 2) {
            handleCurrentWithdrawal();
        } else if (response == 3) {
            displayBalance();
        }
    }

    // Method to handle savings withdrawal
    private void handleSavingsWithdrawal() {
        System.out.println("How much money would you like to withdraw from your savings account?");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (checkMoney(input)) {
            account.setBalance(account.getBalance() - input);  // Deduct balance
            System.out.println(input + "$ has been debited. New balance: " + account.getBalance() + "$");
            updateAccountsFile();  // Update the file with the new balance
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to handle current account withdrawal
    private void handleCurrentWithdrawal() {
        System.out.println("How much money would you like to withdraw from your current account?");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (checkMoney(input)) {
            account.setBalance(account.getBalance() - input);  // Deduct balance
            System.out.println(input + "$ has been debited. New balance: " + account.getBalance() + "$");
            updateAccountsFile();  // Update the file with the new balance
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to display current balance
    private void displayBalance() {
        System.out.println("Your current balance is: " + account.getBalance() + "$");
    }

    // Check if the account has enough balance
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
