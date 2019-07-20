package junit.exercise.greet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GreeterParametrized {
    @ParameterizedTest
    @MethodSource({"getNameExpected"})
    void greetWithandrzej(String received, String expected) {
        String[] andrewList = new String[1];
        andrewList[0] = received;

        String result;
        result = Greeter.greet(andrewList);

        Assertions.assertEquals(expected, result);
    }
    static Stream<Arguments> getNameExpected() {
        return Stream.of(
                Arguments.arguments(null, "Hello my friend."),
                Arguments.arguments("ANDRZEJ", "HELLO ANDRZEJ!"),
                Arguments.arguments("AnDrZeJ", "Hello AnDrZeJ."),
                Arguments.arguments("andrzej", "Hello andrzej.")
        );
    }
}
