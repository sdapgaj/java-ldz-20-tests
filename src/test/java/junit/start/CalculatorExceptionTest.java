package junit.start;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorExceptionTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero_tryCatch() {
        int a = 125;
        int b = 0;

        try {
            int result = calculator.divide(a, b);
            fail("Dividing by zero should throw Exception");
        } catch (ArithmeticException ignored) {
        }
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        int a = 125;
        int b = 0;

        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }

}
