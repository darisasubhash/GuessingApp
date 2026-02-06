import com.model.GameConfig;
import exception.InvalidInputException;
import service.GuessValidator;
import service.HintService;
import service.ValidationService;

import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Use Case 4: Error Handling & Validation
 *
 * This class coordinates the game execution while ensuring
 * all user inputs are safely validated before processing.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept user input
 * - Validate input using ValidationService
 * - Handle game flow without crashing on invalid input
 *
 * @author Developer
 * @version 4.0
 */

public class GuessingApp {
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to Guessing App ");
        GameConfig config=new GameConfig();
        config.showRules();
        Scanner scan=new Scanner(System.in);
        int attempts=0;
        int hint=1;
        /*
         *Game loop runs until the
         * Player exhausts the maximum attempts
         */
        while(attempts< config.getMAX_ATTEMPTS()){
            System.out.println("Enter your Guess : ");
            /*
             *User input is validated before
             * being used in the game
             */
            int guess= ValidationService.validateInput(scan.nextLine());
            attempts++;
            String result= GuessValidator.validateGuess(config.getTargetNumber(), guess);
            if (!"CORRECT".equals(result) && hint<= config.getMAX_HINTS()){
                String acquiredHint=HintService.generateHint(config.getTargetNumber(), hint++);
                System.out.println(acquiredHint);
            }
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
