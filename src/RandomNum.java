
import java.util.Random;


public class RandomNum {
    public static void main(String[] args) {

        Random random = new Random();

        int number1;
        int number2;
        int number3;

        number1 = random.nextInt(1, 101);
        number2 = random.nextInt(1, 101);
        number3 = random.nextInt(1, 101);


        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);

        double number4 = random.nextDouble();
        System.out.println(number4);

        boolean isHeads;
        isHeads = random.nextBoolean();

        if(isHeads){
            System.out.println("Heads");
        }
        else {
            System.out.println("Tails");
        }

    }
}
