package junit.exercise.greet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterIntegrationTest {

    @Test
    void mockExample() {
        Greeter mockedGreeter = Mockito.mock(Greeter.class);

        Mockito.when(mockedGreeter.greet(null)).thenReturn("ABC");

        assertThat(mockedGreeter.greet(null)).isEqualTo("ABC");

        Mockito.verify(mockedGreeter, Mockito.times(1)).greet(null);
        Mockito.verify(mockedGreeter, Mockito.never()).greet("A");

        assertThat(mockedGreeter.prepareScreamingHello(new ArrayList<>())).isNull();
    }

    @Test
    void spyExample() {
        Greeter mockedGreeter = Mockito.spy(Greeter.class);

        Mockito.when(mockedGreeter.greet(null)).thenReturn("ABC");

        assertThat(mockedGreeter.greet(null)).isEqualTo("ABC");

        Mockito.verify(mockedGreeter, Mockito.times(1)).greet(null);
        Mockito.verify(mockedGreeter, Mockito.never()).greet("A");

        assertThat(mockedGreeter.prepareScreamingHello(new ArrayList<>())).isEqualTo("");
    }

    @Test
    void testGreetCallsPrepareHelloMethodsCorrectly1() {
        Greeter mockedGreeter = Mockito.spy(Greeter.class);

        mockedGreeter.greet("Ala", "PIOTREK");

        Mockito.verify(mockedGreeter, Mockito.times(1)).prepareScreamingHello(Arrays.asList("PIOTREK"));
        Mockito.verify(mockedGreeter, Mockito.times(1)).prepareRegularHello(Arrays.asList("Ala"));
    }

    @Test
    void testGreetCallsPrepareHelloMethodsCorrectly2() {
        Greeter mockedGreeter = Mockito.spy(Greeter.class);

        mockedGreeter.greet("Ala", "PiOtReK", "Anna", "robert");

        Mockito.verify(mockedGreeter, Mockito.times(1)).prepareScreamingHello(new ArrayList<>());
        Mockito.verify(mockedGreeter, Mockito.times(1)).prepareRegularHello(Arrays.asList("Ala", "PiOtReK", "Anna", "robert"));
    }

    @ParameterizedTest
    @CsvSource({"'abc', '', 'abc'", "'', 'abc', 'abc'", "'abc', 'def', 'def abc'"})
    void testGreetJoinsHellosCorrectly(String screamingHello, String regularHello, String expected) {
        Greeter mockedGreeter = Mockito.spy(Greeter.class);
        Mockito.when(mockedGreeter.prepareScreamingHello(ArgumentMatchers.anyList())).thenReturn(screamingHello);
        Mockito.when(mockedGreeter.prepareRegularHello(ArgumentMatchers.anyList())).thenReturn(regularHello);

        String result = mockedGreeter.greet("whatever");

        assertThat(result).isEqualTo(expected);
    }

}
