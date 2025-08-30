import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    // Slot machine symbols with realistic frequencies
    private static final String[] SYMBOLS = {"🍒", "🍋", "🍊", "🍉", "🍇", "⭐", "🔔", "7️⃣", "💎"};
    private static final int[] SYMBOL_WEIGHTS = {25, 20, 18, 15, 12, 6, 3, 1, 1}; // Weighted probabilities
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 100;

        // Welcome header
        printWelcomeBox();
        printPayoutTable();

        while (balance > 0) {
            printSeparator();
            System.out.printf("💰 Current Balance: $%d%n", balance);

            // Get valid bet
            int bet = getBet(scanner, balance);
            balance -= bet;

            // Spin and display results
            System.out.println("\n🎰 Spinning...");
            simulateSpinAnimation();

            String[] result = spinReels();
            printSlotResult(result);

            // Calculate winnings
            int payout = calculatePayout(result, bet);

            if (payout > 0) {
                System.out.printf("🎉 WINNER! You won $%d! 🎉%n", payout);
                balance += payout;
            } else {
                System.out.println("💔 No match this time! Better luck next spin!");
            }

            // Check if player wants to continue
            if (!askPlayAgain(scanner)) {
                break;
            }
        }


        if (balance <= 0) {
            printGameOver(balance);
        } else {
            // Player chose to quit with money remaining
            System.out.println("\n+--------------------------------------+");
            System.out.println("🎉 Thanks for playing!");
            System.out.printf("💰 Final Balance: $%d%n", balance);
            if (balance > 100) {
                System.out.println("🏆 Congratulations! You finished ahead!");
            }
            System.out.println("+--------------------------------------+");
        }
        scanner.close();
    }

    /**
     * Get valid bet amount from player
     */
    private static int getBet(Scanner scanner, int balance) {
        while (true) {
            System.out.printf("💵 Place your bet (1 - %d): $", balance);
            try {
                int bet = Integer.parseInt(scanner.nextLine().trim());

                if (bet < 1) {
                    System.out.println("❌ Minimum bet is $1!");
                } else if (bet > balance) {
                    System.out.println("❌ Insufficient funds!");
                } else {
                    return bet;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number!");
            }
        }
    }

    /**
     * Spin the reels
     */
    private static String[] spinReels() {
        String[] reels = new String[3];
        for (int i = 0; i < 3; i++) {
            reels[i] = getWeightedRandomSymbol();
        }
        return reels;
    }

    /**
     * Get random symbol
     */
    private static String getWeightedRandomSymbol() {
        int totalWeight = 0;
        for (int weight : SYMBOL_WEIGHTS) {
            totalWeight += weight;
        }

        int randomValue = random.nextInt(totalWeight);
        int currentWeight = 0;

        for (int i = 0; i < SYMBOLS.length; i++) {
            currentWeight += SYMBOL_WEIGHTS[i];
            if (randomValue < currentWeight) {
                return SYMBOLS[i];
            }
        }
        return SYMBOLS[0]; // Fallback
    }

    /**
     * Calculate payout
     */
    private static int calculatePayout(String[] reels, int bet) {
        // Three of a kind (jackpot)
        if (reels[0].equals(reels[1]) && reels[1].equals(reels[2])) {
            return switch (reels[0]) {
                case "🍒" -> bet * 5;   // Common fruit
                case "🍋" -> bet * 8;   // Common fruit
                case "🍊" -> bet * 10;  // Common fruit
                case "🍉" -> bet * 15;  // Less common fruit
                case "🍇" -> bet * 20;  // Less common fruit
                case "⭐" -> bet * 50;  // Special symbol
                case "🔔" -> bet * 75;  // Special symbol
                case "7️⃣" -> bet * 100; // Lucky seven
                case "💎" -> bet * 500; // Jackpot symbol
                default -> 0;
            };
        }

        // Two of a kind (smaller payouts)
        long matchCount = java.util.Arrays.stream(reels)
                .collect(java.util.stream.Collectors.groupingBy(s -> s, java.util.stream.Collectors.counting()))
                .values().stream().max(Long::compare).orElse(0L);

        if (matchCount == 2) {
            String matchedSymbol = java.util.Arrays.stream(reels)
                    .collect(java.util.stream.Collectors.groupingBy(s -> s, java.util.stream.Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 2)
                    .map(java.util.Map.Entry::getKey)
                    .findFirst().orElse("");

            return switch (matchedSymbol) {
                case "🍒", "🍋" -> bet;     // Break even
                case "🍊", "🍉" -> bet * 2; // Small win
                case "🍇" -> bet * 3;       // Medium win
                case "⭐", "🔔" -> bet * 5; // Good win
                case "7️⃣" -> bet * 10;     // Great win
                case "💎" -> bet * 25;     // Excellent win
                default -> 0;
            };
        }

        return 0; // No match
    }

    /**
     * Print slot machine result
     */
    private static void printSlotResult(String[] reels) {
        System.out.println();
        System.out.println("+-------------------+");
        System.out.printf("| %s | %s | %s |%n", reels[0], reels[1], reels[2]);
        System.out.println("+-------------------+");
    }

    /**
     * Simulate spinning animation
     */
    private static void simulateSpinAnimation() {
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Ask if player wants to play again
     */
    private static boolean askPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("\n🔄 Play again? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
            }
        }
    }

    /**
     * Print welcome box
     */
    private static void printWelcomeBox() {
        System.out.println("+--------------------------------------+");
        System.out.println("|        JAVA SLOT MACHINE             |");
        System.out.println("|                                      |");
        System.out.println("|        🍒🍋🍊🍉🍇⭐🔔7️⃣💎          |");
        System.out.println("|                                      |");
        System.out.println("|        Starting Balance: $100        |");
        System.out.println("+--------------------------------------+");
    }

    /**
     * Print payout table for player reference
     */
    private static void printPayoutTable() {
        System.out.println("\n📊 PAYOUT TABLE (3 of a kind):");
        System.out.println("+--------+------------------------+");
        System.out.println("| Symbol | Multiplier             |");
        System.out.println("+--------+------------------------+");
        System.out.println("|   🍒   | 5x bet                 |");
        System.out.println("|   🍋   | 8x bet                 |");
        System.out.println("|   🍊   | 10x bet                |");
        System.out.println("|   🍉   | 15x bet                |");
        System.out.println("|   🍇   | 20x bet                |");
        System.out.println("|   ⭐   | 50x bet                |");
        System.out.println("|   🔔   | 75x bet                |");
        System.out.println("|   7️⃣   | 100x bet               |");
        System.out.println("|   💎   | 500x bet (JACKPOT!)    |");
        System.out.println("+--------+------------------------+");
        System.out.println("💡 Two of a kind pays smaller amounts!");
    }

    /**
     * Print separator line
     */
    private static void printSeparator() {
        System.out.println("\n" + "+".repeat(40));
    }

    /**
     * Print game over message when player runs out of money
     */
    private static void printGameOver(int finalBalance) {
        System.out.println("\n+--------------------------------------+");
        System.out.println("💸 Game Over! You're out of money!");
        System.out.println("🎰 Better luck next time!");
        System.out.printf("💰 Final Balance: $%d%n", finalBalance);
        System.out.println("+--------------------------------------+");
    }
}