import com.model.GameConfig;
import exception.InvalidInputException;
import service.*;

import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Use Case 6: Game Restart & Exit
 *
 * This class coordinates the complete game lifecycle,
 * allowing the player to replay or exit gracefully.
 *
 * Responsibilities:
 * - Start a new game session
 * - Execute the guessing flow
 * - Persist game results
 * - Restart or exit based on user choice
 *
 * @author Developer
 * @version 6.0
 */

public class GuessingApp {
    public static void main(String[] args) throws InvalidInputException {
        Scanner scan=new Scanner(System.in);
        boolean restart;
        System.out.println("=========================");
        System.out.println("Welcome to Guessing App ");
        System.out.println("=========================");
        /*
         *Outer loop controls whether
         * a new game session should start
         */
        do{
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
            /*
             *Player decides whether to
             * restart the game or exit
             */
            restart=GameController.restartGame(scan);
        }while(restart);
    }
}
