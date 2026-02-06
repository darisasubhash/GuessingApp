package service;

/*
 * Use Case 2: User Guess Submission
 *
 * This class is responsible for comparing
 * the user's guess with the target number.
 *
 * It does NOT handle input or output.
 */

public class GuessValidator {
    /*
     *compares guess with target and
     * return the camparison result
     */
    public static String validateGuess(int target,int number){
        if(target==number){
            return "CORRECT";
        }
        else if (number<target) {
            return "LOW";
        }
        return "HIGH";
    }
}
