import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class DiceRolling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.print("Enter the number of dice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // clear invalid input
                continue;
            }

            int numOfDice = scanner.nextInt();
            if (numOfDice <= 0) {
                System.out.println("Number of dice must be positive.");
                continue;
            }

            int[] rolls = new int[numOfDice];
            int total = 0;

            // Roll the dice
            for (int i = 0; i < numOfDice; i++) {
                rolls[i] = random.nextInt(6) + 1;
                total += rolls[i];
            }

            // Print results
            printDiceSideBySide(rolls);
            System.out.println("You rolled: " + Arrays.toString(rolls));
            System.out.println("The total is " + total);

            // Ask user if they want to play again
            System.out.print("Roll again? (y/n): ");
            String answer = scanner.next();
            playAgain = answer.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    static void printDiceSideBySide(int[] rolls) {
        String[][] diceFaces = {
                { " ------- ",
                        "|       |",
                        "|   ●   |",
                        "|       |",
                        " ------- " },
                { " ------- ",
                        "| ●     |",
                        "|       |",
                        "|     ● |",
                        " ------- " },
                { " ------- ",
                        "| ●     |",
                        "|   ●   |",
                        "|     ● |",
                        " ------- " },
                { " ------- ",
                        "| ●   ● |",
                        "|       |",
                        "| ●   ● |",
                        " ------- " },
                { " ------- ",
                        "| ●   ● |",
                        "|   ●   |",
                        "| ●   ● |",
                        " ------- " },
                { " ------- ",
                        "| ●   ● |",
                        "| ●   ● |",
                        "| ●   ● |",
                        " ------- " }
        };

        // Print each line of all dice side by side
        for (int line = 0; line < 5; line++) {
            for (int roll : rolls) {
                System.out.print(diceFaces[roll - 1][line] + "  ");
            }
            System.out.println();
        }
    }
}
