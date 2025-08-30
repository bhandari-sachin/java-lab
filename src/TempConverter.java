
import java.util.Scanner;
public class TempConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double temp;
        double newTemp;

        String unit;

        System.out.print("Enter the temperature: ");
        temp = scanner.nextDouble();

        System.out.print("Convert to Celsius or Fahrenheit? ( C or F): ");
        unit = scanner.next().toUpperCase();

        newTemp = (unit.equals("C")) ? (temp - 32) * 5/9 : (temp * 5 / 9 ) + 32;
        System.out.printf("The converted temperature is: %.2f°%s", newTemp, unit);


        scanner.close();

    }
}
