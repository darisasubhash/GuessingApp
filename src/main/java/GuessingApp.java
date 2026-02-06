import com.model.GameConfig;
import exception.InvalidInputException;
import service.GuessValidator;
import service.HintService;
import service.StorageService;
import service.ValidationService;

import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Use Case 5: Game Result Storage
 *
 * This class coordinates the complete game flow
 * and persists the final result after completion.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game result at the end
 *
 * @author Developer
 * @version 5.0
 */

public class GuessingApp {
    public static void main(String[] args) throws InvalidInputException {
        Scanner scan=new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("Welcome to Guessing App ");
        System.out.println("=========================");
        System.out.println("Enter Player Name : ");
        String player=scan.nextLine();
        GameConfig config=new GameConfig();
        config.showRules();
        int attempts=0;
        int hint=1;
        /*
         *Tracks whether the player
         * successfully guessed the number
         */
        boolean win=false;
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
                win=true;
                break;
            }
        }
        /*
         *Final game result is persisted
         * after the game loop completes
         */
        StorageService.saveResult(player,attempts,win);
    }
}
