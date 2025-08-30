
import java.util.Scanner;

public class CompoundInterestCalc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double principal;
        double rate;
        int timesCompounded;
        int years;
        double amount;


        System.out.println("Enter principal: ");
        principal = scanner.nextDouble();

        System.out.println("Enter the interest rate: (in %): ");
        rate = scanner.nextDouble() / 100;

        System.out.println("Enter the # of times compounded per year: ");
        timesCompounded = scanner.nextInt();

        System.out.println("Enter the # of years: ");
        years = scanner.nextInt();

        amount = principal * Math.pow(1 + rate / timesCompounded, timesCompounded * years);
        System.out.printf("The amount after %d years is $%.2f", years, amount);


        scanner.close();


    }
}
