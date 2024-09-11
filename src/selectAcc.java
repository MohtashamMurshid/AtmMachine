import java.util.List;
import java.util.Scanner;

public class selectAcc {
    private Accounts account;
    private List<Accounts> accountsList;  // List of all accounts
    private String filePath;  // File path to store account data

    // Constructor to accept the logged-in account and necessary parameters
    public selectAcc(Accounts account, List<Accounts> accountsList, String filePath) {
        this.account = account;
        this.accountsList = accountsList;
        this.filePath = filePath;
    }

    // Method to handle the account selection menu
    public void select() {
        Scanner myObj = new Scanner(System.in);
        int response;

        do {
            System.out.println("1. Withdraw from Savings \n" +
                    "2. Withdraw from Current \n" +
                    "3. Show Balance \n" +
                    "4. Exit \n");
            System.out.print("Enter your choice: ");
            response = myObj.nextInt();

            // Pass the response to the DisplayAmount class for handling the action
            if (response != 4) {
                new displayAmount(account, response, accountsList, filePath);
            }
        } while (response != 4);  // Continue until the user chooses to exit
    }
}
