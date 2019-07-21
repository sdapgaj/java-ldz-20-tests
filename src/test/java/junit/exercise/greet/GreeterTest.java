package junit.exercise.greet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

    Greeter greeter = new Greeter();

    @Test
    void greetEmptyList() {
        //Given
        String[] andrewList = new String[0];

        //When
        String result;
        result = greeter.greet(andrewList);
        //Then
        Assertions.assertEquals("Hello my friend.", result, "Lipton");
    }

    @Test
    void greetWithNull() {
        //Given
        String[] andrewList = new String[1];
        andrewList[0] = null;


        //When
        String result;
        result = greeter.greet(andrewList);
        //Then
        Assertions.assertEquals("Hello my friend.", result, "Nie jest dobrze.");
    }

    @Test
    void greetWithANDRZEJ() {
        //Given
        String[] andrewList = new String[1];
        andrewList[0] = "ANDRZEJ";


        //When
        String result;
        result = greeter.greet(andrewList);
        //Then
        Assertions.assertEquals("HELLO ANDRZEJ!", result, "Nie jest dobrze.");
    }

    @Test
    void greetWithAnDrZeJ() {
        String[] andrewList = new String[1];
        andrewList[0] = "AnDrZeJ";

        String result;
        result = greeter.greet(andrewList);

        Assertions.assertEquals("Hello AnDrZeJ.", result);
    }

    @Test
    void greetWithandrzej() {
        String[] andrewList = new String[1];
        andrewList[0] = "andrzej";

        String result;
        result = greeter.greet(andrewList);

        Assertions.assertEquals("Hello andrzej.", result);
    }
}
