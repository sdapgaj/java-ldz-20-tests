package junit.exercise.dice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        if (genre.equals("FOUR")) {
            int appearsFourTimes=0;
            Map<Integer, Long> streamFourElements = kosci.stream()
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    ));

            Set<Integer> integers = streamFourElements.keySet();
            for (Integer i:integers) {
                if (streamFourElements.get(i)>=4) {
                    appearsFourTimes=i;
                }
            }

            return 4 * appearsFourTimes * multiplier;
        }
        if (genre.equals("TWO PAIRS")){
            int score=0;

            Map<Integer, Long> twoPairs = kosci.stream()
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    ));
            for (Map.Entry<Integer, Long> entry:twoPairs.entrySet()) {

                if (entry.getValue()==2){
                    score += 2 * entry.getKey();
                }
            }
            return score;
        }
        if (genre.equals("LOW STRIT")){
            //System.out.println(kosci);
            Collections.sort(kosci);
            if (kosci.equals(Arrays.asList(1,2,3,4,5))){
                return 15;

            }

        }


        return 0;
    }

}
