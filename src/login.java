import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class login {
    private List<Accounts> accounts;  // List of all accounts
    private String filePath;  // File path to the accounts file

    // Constructor to initialize the list of accounts and the file path
    public login(List<Accounts> accounts, String filePath) {
        this.accounts = accounts;
        this.filePath = filePath;
    }

    // Method to handle the login process
    public void performLogin() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        // Input for Account Number
        System.out.println("Enter Account Number:");
        Integer accountNumber = Integer.valueOf(myObj.nextLine());

        // Input for Password
        System.out.println("Enter Password:");
        String password = myObj.nextLine();

        // Validate account number and password
        boolean loginSuccessful = false;
        for (Accounts account : accounts) {
            if (Objects.equals(accountNumber, account.getAccountNumber()) &&
                    Objects.equals(password, account.getPassword())) {
                System.out.println("Login successful!");
                loginSuccessful = true;

                // Pass the logged-in account, accounts list, and file path to selectAcc
                selectAcc selectAcc = new selectAcc(account, accounts, filePath);
                selectAcc.select();
                break;
            }
        }

        if (!loginSuccessful) {
            System.out.println("Failed Login");
        }
    }
}
