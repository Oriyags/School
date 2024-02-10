package il.co.oriya.guessthenumber;

import java.util.Random;

public class GuessTheNumber {
    private int randomNumber;
    private int attempts;

    public GuessTheNumber(int min, int max) {
        Random rnd = new Random();
        randomNumber = rnd.nextInt(max - min + 1) + min;
        attempts = 0;
    }

    public boolean checkGuess(int guess) {
        attempts++;
        return guess == randomNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getFeedback() {
        if (attempts < 5) {
            return "Great";
        } else if (attempts >= 5 && attempts <= 10) {
            return "Good";
        } else {
            return "Too many attempts";
        }
    }
}