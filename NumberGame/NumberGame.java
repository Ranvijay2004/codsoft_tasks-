import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("===================================");
        System.out.println("       WELCOME TO NUMBER GAME");
        System.out.println("===================================");

        do {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    guessedCorrectly = true;

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");

                    System.out.println("Attempts Used : " + attempts);

                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    score += roundScore;

                    System.out.println("Round Score : " + roundScore);
                    break;
                }

                else if (guess < randomNumber) {
                    System.out.println("Too Low!");
                }

                else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left : " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("Correct Number was : " + randomNumber);
            }

            System.out.println("\nCurrent Total Score : " + score);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y');

        System.out.println("\n===================================");
        System.out.println("Thank You for Playing!");
        System.out.println("Final Score : " + score);
        System.out.println("===================================");

        sc.close();
    }
}