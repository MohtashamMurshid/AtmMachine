![image](https://github.com/user-attachments/assets/61cb90bb-3a38-49c7-9e7d-3789768bac81)
Here's a sample `README.md` for your project:

---

# ATM Machine Simulation

This project is an **ATM Machine Simulation** written in Java. It allows users to log into their account, view their balance, and perform transactions like deposits and withdrawals. The account data is stored in a text file, and all transactions update the account balance both in the application and the file.

## Features

1. **User Login**: 
   - Users can log in using their account number and password. 
   - The system checks the validity of the credentials against the accounts stored in a text file.

2. **Account Types**:
   - The system supports two types of accounts:
     - **Savings Account**
     - **Current Account**

3. **Transactions**:
   - **Withdrawals**: Users can withdraw money from either their savings or current account. 
   - **Deposits**: Users can deposit money into their savings or current account.
   - **Balance Check**: Users can check their current account balance.

4. **Persistent Data**:
   - All transactions (withdrawals or deposits) update the balance of the user in the text file.

## Installation and Setup

1. **Clone the Repository**:
   Clone the project to your local machine:
   ```bash
   git clone https://github.com/MohtashamMurshid/AtmMachine.git
   ```

2. **Ensure Java is Installed**:
   Make sure you have Java installed on your machine. If not, download and install it from [Oracle's website](https://www.oracle.com/).

3. **Create a `accounts.txt` File**:
   Create a text file named `accounts.txt` in the `src` folder. Each line in the file should represent one account, in the following format:
   ```
   username,accountNumber,password,balance
   ```
   Example:
   ```
   john_doe,123456,pass123,1000
   jane_doe,654321,pass456,2000
   ```

4. **Run the Application**:
   You can compile and run the application using any Java IDE (e.g., IntelliJ IDEA, Eclipse) or from the terminal:
   ```bash
   javac Main.java
   java Main
   ```

## Usage

1. **Login**: 
   - Enter your account number and password when prompted.
   - The system will validate your credentials against the accounts stored in the `accounts.txt` file.
   
2. **Select Transaction**:
   After logging in, you will be presented with options to:
   - Withdraw or deposit money into/from your savings or current account.
   - Check your current balance.
   - Exit the application.

3. **Withdraw/Deposit**:
   - You can enter the amount you wish to withdraw or deposit.
   - If you attempt to withdraw more money than your balance, the system will display an "Insufficient Balance" message.

4. **Balance Update**:
   - After a successful transaction, your account balance will be updated in both the application and the `accounts.txt` file.

## Project Structure

```
ATM-Machine-Simulation/
│
├── src/
│   ├── Accounts.java               # Holds account details (username, account number, password, balance)
│   ├── AccountsManager.java         # Loads account data from the accounts.txt file
│   ├── login.java                   # Handles user login functionality
│   ├── selectAcc.java               # Presents options to the user after login (e.g., balance check, withdrawal)
│   ├── manageTransactions.java      # Handles deposits and withdrawals for savings and current accounts
│   ├── Main.java                    # Entry point for the application
│   └── accounts.txt                 # Stores user account data in CSV format (username, accountNumber, password, balance)
│
├── README.md                        # Project documentation (this file)
```

## Example Flow

1. User logs in with their account number and password.
2. After a successful login, they can:
   - Withdraw money
   - Deposit money
   - Check their balance
3. If a withdrawal or deposit is successful, the `accounts.txt` file is updated with the new balance.

## Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request if you'd like to improve the project or fix a bug.



---

