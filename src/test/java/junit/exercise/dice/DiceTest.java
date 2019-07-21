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
                Arguments.arguments(Arrays.asList(2,2,4,1,5), "PAIR", true, 8)
        );
    }

}
