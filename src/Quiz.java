import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {

        // JAVA QUIZ GAME

        String[] questions = {
                "1. What is the size of an int in Java?",
                "2. Which keyword is used to inherit a class in Java?",
                "3. What is the default value of a boolean in Java?",
                "4. Which method is the entry point of a Java program?",
                "5. What is the difference between '==' and '.equals()' in Java?",
                "6. Which collection allows duplicate elements in Java?",
                "7. What is the output of 5 / 2 in Java?",
                "8. What does JVM stand for?",
                "9. Which exception is thrown when dividing by zero?",
                "10. What is the keyword to define a constant in Java?"
        };

        String[][] options = {
                {"a) 2 bytes", "b) 4 bytes", "c) 8 bytes", "d) 16 bytes"},
                {"a) extend", "b) inherits", "c) implements", "d) super"},
                {"a) true", "b) false", "c) 0", "d) null"},
                {"a) start()", "b) main()", "c) run()", "d) init()"},
                {"a) '==' compares values, '.equals()' compares references",
                        "b) '==' compares references, '.equals()' compares values",
                        "c) Both are same", "d) None"},
                {"a) Set", "b) List", "c) Map", "d) Tree"},
                {"a) 2", "b) 2.5", "c) 3", "d) 0"},
                {"a) Java Variable Machine", "b) Java Virtual Machine", "c) Java Very Machine", "d) Java Version Manager"},
                {"a) ArithmeticException", "b) NullPointerException", "c) IOException", "d) ArrayIndexOutOfBoundsException"},
                {"a) final", "b) const", "c) static", "d) immutable"}
        };

        char[] answers = {'b', 'a', 'b', 'b', 'b', 'b', 'a', 'b', 'a', 'a'};

        int score = 0;
        char choice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("+--------------------------+");
        System.out.println("|   Welcome to the Quiz!   |");
        System.out.println("+--------------------------+");


        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);


            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);

            if (choice == answers[i]) {
                System.out.println("Correct!");
                score++;

            }
            else {
                System.out.println("Wrong!");
            }

            System.out.println();
        }
        System.out.println("Your score is " + score + " out of " + questions.length);

        scanner.close();


    }
}