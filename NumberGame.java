import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean userGuessedCorrectly = false;
            
            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter guess: ");
                
                try {
                    int guess = Integer.parseInt(scanner.nextLine());
                    attempts++;
                    
                    if (guess < targetNumber) {
                        System.out.println("Too low!");
                    } else if (guess > targetNumber) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Congratulations! You win the game");
                        userGuessedCorrectly = true;
                        break;
                    }
                    
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                }
            }
            
            if (!userGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.print("Would you like to play another round? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        
        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}