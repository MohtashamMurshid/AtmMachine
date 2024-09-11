import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountsManager {

    // Method to load accounts from a txt file
    public List<Accounts> loadAccounts(String filePath) {
        List<Accounts> accountsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] accountData = line.split(",");  // Split by comma
                // Create an Accounts object and add to the list
                Accounts account = new Accounts(accountData[0], Integer.parseInt(accountData[1]), accountData[2], Integer.parseInt(accountData[3]));
                accountsList.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accountsList;
    }

    // Method to save accounts to a txt file
    public void saveAccounts(List<Accounts> accounts, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Accounts account : accounts) {
                // Correct way to write each account's details to the file
                writer.write(account.getUsername() + "," + account.getAccountNumber() + "," + account.getPassword() + "," + account.getBalance() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
