import com.model.GameConfig;
import service.GuessValidator;

import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 *
 * @author Developer
 * @version 2.0
 */


public class GuessingApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Guessing App ");
        GameConfig config=new GameConfig();
        config.showRules();
        Scanner scan=new Scanner(System.in);
        int attempts=0;
        /*
         *Game loop runs until the
         * Player exhausts the maximum attempts
         */
        while(attempts< config.getMAX_ATTEMPTS()){
            System.out.println("Enter your Guess : ");
            int guess= scan.nextInt();
            attempts++;
            String result= GuessValidator.validateGuess(config.getTargetNumber(), guess);
            System.out.println(result);
            /*
             * Stops loop immediately if
             * correct number is guessed
             */
            if ("CORRECT".equalsIgnoreCase(result)){
                break;
            }
        }
    }
}
