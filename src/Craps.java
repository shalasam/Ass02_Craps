import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        Random rnd = new Random(); // Create a Random object

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out. You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                System.out.println("Point is set to " + sum);
                boolean continueRolling = true;

                while (continueRolling) {
                    int newDie1 = rnd.nextInt(6) + 1;
                    int newDie2 = rnd.nextInt(6) + 1;
                    int newSum = newDie1 + newDie2;

                    System.out.println("\nRolling again...");
                    System.out.println("Die 1: " + newDie1);
                    System.out.println("Die 2: " + newDie2);
                    System.out.println("Sum: " + newSum);

                    if (newSum == sum) {
                        System.out.println("Made the point! You win!");
                        continueRolling = false;
                    } else if (newSum == 7) {
                        System.out.println("Seven out! You lose!");
                        continueRolling = false;
                    } else {
                        System.out.println("Trying for the point...");
                    }
                }
            }

            // Ask the user if they want to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();

            // Update the playAgain variable based on user input
            playAgain = playAgainInput.equals("yes");
        }

        // Close the Scanner
        scanner.close();
    }
}