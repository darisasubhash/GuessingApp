package com.model;

import java.util.Random;

/** Use Case 1: Game Initialization
 ** This class is responsible for:
 ** - Setting game boundaries
 ** - Generating a random target number
 ** - Displaying game rules
 ** * Demonstrates:
 ** - Encapsulation
 ** - Constructor initialization
 ** - Random number generation
 **/

public class GameConfig {
    private final int MIN=1;
    private final int MAX=100;
    private final int MAX_ATTEMPTS=7;
    private final int MAX_HINTS=3;
    private int targetNumber;

    public  GameConfig(){
        Random random=new Random();
        targetNumber = random.nextInt(MAX-MIN+1)+MIN;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }

    public int getMAX_HINTS() {
        return MAX_HINTS;
    }

    public int getTargetNumber() {
        return targetNumber;
    }
    public void showRules(){
        System.out.println("Guess a Number Between "+MIN+" and "+MAX);
        System.out.println("You have "+MAX_ATTEMPTS+" attempts ");
        System.out.println("Hints will be provided after wrong guesses\n");
    }
}
