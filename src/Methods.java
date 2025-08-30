
public class Methods {
    public static void main(String[] args) {

        // method = a block of reusable code that is executed when called ()


        int age = 12;

        if (ageCheck(age)) {
            System.out.println("You may sign up");

        } else {
            System.out.println("You may not sign up");
        }


    }
    
    /*

    static void happyBirthday(String name, int age) {
        System.out.println("Happy birthday to you!");
        System.out.printf("Happy birthday dear %s!\n", name);
        System.out.printf("You are %d years old!\n", age);
        System.out.println("Happy birthday to you!\n");

    }

    static double square(double number) {
        return number * number;
    }

    static double cube(double number) {
        return number * number * number;

    }

    static String getFullName(String first, String last) {
        return first + " " + last;
    }
    
     */

    static boolean ageCheck(int age) {
        return age >= 18;
    }
}