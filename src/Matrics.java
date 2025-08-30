import java.util.Scanner;

public class Matrics {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);


        int rows;
        int cols;
        char symbol;

        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        cols = scanner.nextInt();
        System.out.print("Enter the symbol: ");
        symbol = scanner.next().charAt(0);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++ ) {
                System.out.print(symbol);
            }
            System.out.println();

        }




        scanner.close();
    }
}
