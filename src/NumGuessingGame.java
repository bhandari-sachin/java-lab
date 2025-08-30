import java.util.Random;
import java.util.Scanner;

public class NumGuessingGame {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int guess;
        int attempts = 0;
        int min = 1;
        int max = 100;
        int randomNum = random.nextInt(min, max + 1);

        System.out.println("NUMBER GUESSING GAME\n");
        System.out.printf("Guess a number between %d-%d\n", min, max);

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNum) {
                System.out.println("Too low, try again!");
            } else if (guess > randomNum) {
                System.out.println("Too high, try again!");
            } else {
                System.out.println("Congratulations! You guessed the number " + randomNum + "!");
                System.out.println("Attempts: " + attempts);
            }

        } while (guess != randomNum);

        scanner.close();
    }
}
