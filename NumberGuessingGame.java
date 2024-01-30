package game;
import java.util.Scanner;
public class NumberGuessingGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        playGame(scanner);
        scanner.close();
	}
	private static void playGame(Scanner scanner) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100. Try to guess it!");

        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber = generateRandomNumber(lowerBound, upperBound);
        int maxAttempts = 10;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            scanner.nextLine(); 

            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                continue;
            }

            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
    }

    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
