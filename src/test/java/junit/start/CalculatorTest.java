package junit.start;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void executedOnlyOnce() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void createCalculator(){
        System.out.println("@BeforeEach");
        calculator = new Calculator();
    }

    @Test
    void add_shouldReturnTwo_whenAddingOneAndOne() {
        //Given
        int a = 1;
        int b = 1;

        //When
        int result = calculator.add(a, b);

        //Then
        assertEquals(2, result);
    }

    @Test
    void add_shouldReturnZero_whenAddingOneAndMinusOne() {
        //Given
        int a = 1;
        int b = -1;

        //When
        int result = calculator.add(a, b);

        //Then
        assertTrue(result < 2);
        assertFalse(result > 5);
        assertNotEquals(5, result);
        assertEquals(0, result);
    }

    @AfterEach
    void after() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }

}
