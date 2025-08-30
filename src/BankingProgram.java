import java.util.Scanner;

public class BankingProgram {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        double balance = 0;
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            System.out.println();
            System.out.println("=== Welcome to Banking Program ===");
            System.out.println("1. Show balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> {
                    balance = deposit(balance);
                    showBalance(balance);
                }
                case 3 -> {
                    balance = withdraw(balance);
                    showBalance(balance);
                }
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }
        }

        System.out.println("Thank you for using Banking Program");
        scanner.close();
    }

    static void showBalance(double balance) {
        System.out.printf("Your balance is: $%.2f%n", balance);
    }

    static double deposit(double balance) {
        System.out.print("Enter amount to deposit: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input!");
            scanner.next();
            return balance;
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        }
        return balance;
    }

    static double withdraw(double balance) {
        System.out.print("Enter amount to withdraw: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input!");
            scanner.next();
            return balance;
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        }
        return balance;
    }
}
