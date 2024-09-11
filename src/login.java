import java.util.Objects;
import java.util.Scanner;

public class AccountsController {
    var Mohtasham = new Accounts("Mohtasham", 123456789, "Mohtasham@11" );
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Account Number");
    String userName = myObj.nextLine();  // Read user input

        System.out.println("Enter Password");
    String Password = myObj.nextLine();

        if(Objects.equals(userName, Mohtasham.getName()) && Objects.equals(Password, Mohtasham.getPassword())){
        System.out.println("Login successful!");
    }else {
        System.out.println("Failed Login");
    }
}
