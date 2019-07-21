package junit.exercise.dice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    Dice dice = new Dice();

    @ParameterizedTest
    @MethodSource({"givenexample"})
    void checkScore(List<Integer> kosci, String genre, boolean ifFirst, int expected) {
        int result = dice.metodaZliczajaca(kosci, genre, ifFirst);
        assertEquals(expected, result);
    }

    static Stream<Arguments> givenexample() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(2,2,2,5,5), "FULL", false, 16),
                Arguments.arguments(Arrays.asList(2,2,2,5,5), "FULL", true, 32),
                Arguments.arguments(Arrays.asList(2,2,4,1,5), "PAIR", false, 4),
                Arguments.arguments(Arrays.asList(2,2,4,1,5), "PAIR", true, 8),
                Arguments.arguments(Arrays.asList(2,2,2,1,5), "THREE", true, 12),
                Arguments.arguments(Arrays.asList(2,2,2,2,5), "FOUR", false, 8),
                Arguments.arguments(Arrays.asList(3,3,3,3,5), "FOUR", false, 12),
                Arguments.arguments(Arrays.asList(5,3,3,3,3), "FOUR", false, 12),
                Arguments.arguments(Arrays.asList(5,3,3,3,3), "FOUR", true, 24),
                Arguments.arguments(Arrays.asList(3,3,3,5,6), "FOUR", true, 0),
                Arguments.arguments(Arrays.asList(3,3,5,3,3), "FOUR", true, 24),
                Arguments.arguments(Arrays.asList(3,3,5,5,1), "TWO PAIRS", false, 16),
                Arguments.arguments(Arrays.asList(1,2,3,4,5), "LOW STRIT", false, 15),
                Arguments.arguments(Arrays.asList(2,1,5,4,3), "LOW STRIT", false, 15)
        );
    }

}
