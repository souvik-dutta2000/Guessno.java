import java.util.Random;
import javax.swing.JOptionPane;

public class Guessno {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;

        int score = 100; // Starting score

        Random random = new Random();
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number Game!");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            String input = JOptionPane.showInputDialog("Attempt " + attempt + ": Guess the number between "
                    + lowerBound + " and " + upperBound + "\nYour current score: " + score);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "You have chosen to quit the game.\nThe number was: " + generatedNumber);
                break;
            }

            int guessedNumber = Integer.parseInt(input);

            if (guessedNumber == generatedNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number correctly!\nYour score: " + score);
                break;
            } else if (guessedNumber < generatedNumber) {
                JOptionPane.showMessageDialog(null, "Try Again! The generated number is higher.");
            } else {
                JOptionPane.showMessageDialog(null, "Try Again! The generated number is lower.");
            }

            // Calculate and deduct score based on the number of attempts
            int deduction = 10 * attempt;
            score -= deduction;
        }

        if (score <= 0) {
            JOptionPane.showMessageDialog(null, "Game Over! You ran out of attempts.\nThe number was: " + generatedNumber);
        }
    }
}
