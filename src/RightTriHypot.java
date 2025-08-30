import java.util.Scanner;

public class RightTriHypot {
    public static void main(String[] args) {

        // HYPOTENUSE c = Math.sqrt(a2 + b2)

        Scanner scanner = new Scanner(System.in);

        double a;
        double b;
        double c;

        System.out.println("Enter the length of side A: ");
        a = scanner.nextDouble();

        System.out.println("Enter the length of side B: ");
        b = scanner.nextDouble();

        c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        System.out.println("The hypotenuse (side c) is: " + c + "cm");

        scanner.close();

    }
}
