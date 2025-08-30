import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter first number (or 'exit' to quit): ");
            if (scanner.hasNextDouble()) {
                double num1 = scanner.nextDouble();

                System.out.print("Enter an operator (+, -, *, /, ^, %): ");
                char operator = scanner.next().charAt(0);

                System.out.print("Enter second number: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid number input!");
                    scanner.next(); // clear invalid input
                    continue;
                }
                double num2 = scanner.nextDouble();

                double result = 0;
                boolean validOperation = true;

                switch (operator) {
                    case '+' -> result = num1 + num2;
                    case '-' -> result = num1 - num2;
                    case '*' -> result = num1 * num2;
                    case '/' -> {
                        if (num2 == 0) {
                            System.out.println("Cannot divide by zero");
                            validOperation = false;
                        } else {
                            result = num1 / num2;
                        }
                    }
                    case '^' -> result = Math.pow(num1, num2);
                    case '%' -> result = num1 % num2;
                    default -> {
                        System.out.println("Invalid operator");
                        validOperation = false;
                    }
                }

                if (validOperation) {
                    System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
                }
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.out.println("Invalid input!");
                }
            }
        }
        scanner.close();
    }
}
