public class Keypad {
    public static void main(String[] args) {

        // 2D array = An array where each element is an array
        //            Useful for storing a matrix of data

        char[][] keypad = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}};

        for (char[] row : keypad) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
