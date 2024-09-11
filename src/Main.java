import java.util.List;

public class Main {
    public static void main(String[] args) {
        // File path to the accounts.txt file
        String filePath = "C:\\Users\\hp\\IdeaProjects\\AtmMachine\\src\\accounts.txt";

        // Create an instance of AccountManager
        AccountsManager accountsManager = new AccountsManager();

        // Load accounts from the text file
        List<Accounts> accounts = accountsManager.loadAccounts(filePath);

        // Create an instance of Login, passing the accounts and file path
        login login = new login(accounts, filePath);

        // Perform the login process
        login.performLogin();
    }
}
