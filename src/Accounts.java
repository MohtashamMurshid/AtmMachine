public class Accounts {
    private String username;
    private int accountNumber;
    private String password;
    private Integer Balance;


    // Constructor
    public Accounts() {}

    public Accounts(String username, int accountNumber, String password, Integer balance) {
        this.username = username;
        this.accountNumber = accountNumber;
        this.password = password;
        this.Balance = balance;
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        this.Balance = balance;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
