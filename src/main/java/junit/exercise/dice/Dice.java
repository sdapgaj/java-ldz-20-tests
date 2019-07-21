package junit.exercise.dice;

import java.util.List;

public class Dice {

    public int metodaZliczajaca(List<Integer> kosci, String genre, boolean ifFirst) {
        int multiplier;
        if (ifFirst) {
            multiplier = 2;
        } else {
            multiplier = 1;
        }

        if (genre.equals("FULL")) {
            return 16 * multiplier;
        }
        if (genre.equals("PAIR")) {
            return 4 * multiplier;
        }
        if (genre.equals("THREE")) {
            return 6 * multiplier;
        }
        return 0;
    }
}
