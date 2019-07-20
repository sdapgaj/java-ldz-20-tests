package junit.start;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParametrizedTest {

    Calculator calculator;

    @BeforeEach
    void createCalculator(){
        calculator = new Calculator();
    }

    @ParameterizedTest
//    @CsvSource({"1, 1, 2", "1, -1, 0", "-5, -2, -7"})
//    @CsvFileSource(resources = "/addTestCases.csv")
    @MethodSource({"addRandomTestCases", "addPredefinedTestCases"})
    void add_shouldReturnCorrectValue(int a, int b, int expected) {
        //Given

        //When
        int result = calculator.add(a, b);

        //Then
        assertEquals(expected, result);
    }

    static Stream<Arguments> addRandomTestCases() {
        return new Random()
                .ints(10)
                .boxed()
                .map((it) -> Arguments.arguments(it, it * -1, 0));
    }

    static Stream<Arguments> addPredefinedTestCases() {
        return Stream.of(
                Arguments.arguments(1, 1, 2),
                Arguments.arguments(1, -1, 0),
                Arguments.arguments(-5, -2, -7)
        );
    }

}
