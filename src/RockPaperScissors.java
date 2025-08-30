import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        // Rock paper scissors game

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes";

        do {
            System.out.print("Enter your choice (rock, paper, scissors): ");
            playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("rock") && !playerChoice.equals("scissors") && !playerChoice.equals("paper")) {
                System.out.println("Invalid choice. Try again: ");
                continue;

            }
            computerChoice = choices[random.nextInt(choices.length)];
            System.out.println("Computer: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if (playerChoice.equals("rock") && computerChoice.equals("scissors")) {
                System.out.println("You won!");
            } else if (playerChoice.equals("paper") && computerChoice.equals("rock")) {
                System.out.println("You won!");
            } else if (playerChoice.equals("scissors") && computerChoice.equals("paper")) {
                System.out.println("You won!");
            } else {
                System.out.println("You lose!");
            }

            System.out.print("Play again? yes/no: ");
            playAgain = scanner.nextLine().toLowerCase();

        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing!");


        scanner.close();
    }
}