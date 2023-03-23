import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Initialize a new Random object and Scanner object
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generate a random number between 1 and 100 (inclusive)
        int randomNumber = random.nextInt(100) + 1;
        int userGuess = 0;
        int numberOfAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100 (inclusive). Try to guess it!");

        // Continue asking for user input until the user guesses the correct number
        while (userGuess != randomNumber) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number!");
                System.out.println("It took you " + numberOfAttempts + " attempts to guess the number.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
