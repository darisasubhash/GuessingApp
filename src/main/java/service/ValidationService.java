package service;

import exception.InvalidInputException;

/**
 * Handles validation of user input
 * before it is used in game logic.
 *
 * All input checks are centralized
 * to keep main() clean and focused.
 */

public class ValidationService {
    /*
     * Validates raw user input.
     *
     * Flow:
     * - Convert input to integer
     * - Check allowed range
     * - Throw custom exception if invalid
     */
    public static int validateInput(String input) throws InvalidInputException{
        try{
            int number = Integer.parseInt(input);
            if(number < 1 || number > 100){
                throw new InvalidInputException("Number must be between 1 and 100 ");
            }
            return  number;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input Please enter numbers only ");
        }
    }

}
