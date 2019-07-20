package junit.start;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJCalculatorTest {

    @Test
    void testAddMethod() {
        int a = 12;
        int b = 17;

        int result = new Calculator().add(a, b);

        assertThat(result)
                .withFailMessage("Result is smaller than 0")
                .isGreaterThan(0)
                .withFailMessage("Result is greater than 100")
                .isLessThan(100)
                .withFailMessage("Result should be 29")
                .isNotEqualTo(10)
                .isEqualTo(29);
    }

    @Test
    void stringTest() {
        assertThat("Ala ma kota.")
                .startsWith("Ala")
                .endsWith(".")
                .contains("kot");
    }

    @Test
    void listTest() {
        List<Integer> numbers = Arrays.asList(1, 5, 3, 10);

        assertThat(numbers)
                .contains(1, 3)
                .hasSize(4)
                .allMatch((it) -> it < 20);
    }

    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> new Calculator().divide(5, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("zero");
    }

}
