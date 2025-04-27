import java.util.Scanner;

// ATM Class
class ATM {
    private float balance;
    private int pin;

    // Constructor
    public ATM(float initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Method to authenticate user
    public boolean authenticate(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Method to deposit money
    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " Deposited Successfully.");
        } else {
            System.out.println("Enter a valid amount to deposit.");
        }
    }

    // Method to withdraw money
    public void withdraw(float amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("₹" + amount + " Withdrawn Successfully.");
            } else {
                System.out.println("Insufficient Balance.");
            }
        } else {
            System.out.println("Enter a valid amount to withdraw.");
        }
    }
}

// ATMInterface Class to handle user interaction
class ATMInterface {
    private ATM atm;
    private Scanner scanner;

    // Constructor
    public ATMInterface(ATM atm) {
        this.atm = atm;
        this.scanner = new Scanner(System.in);
    }

    // Start ATM Interface
    public void start() {
        System.out.println("Welcome to the ATM Machine");

        System.out.print("Please enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (atm.authenticate(enteredPin)) {
            menu();
        } else {
            System.out.println("Invalid PIN! Access Denied.");
        }
    }

    // ATM Menu
    private void menu() {
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    float depositAmount = scanner.nextFloat();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    float withdrawAmount = scanner.nextFloat();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// Main Class
public class ATMMachine {
    public static void main(String[] args) {
        // Create ATM object with initial balance and PIN
        ATM atm = new ATM(10000.0f, 1234);

        // Create ATM Interface and start
        ATMInterface atmInterface = new ATMInterface(atm);
        atmInterface.start();
    }
}
