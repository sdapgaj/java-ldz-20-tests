package junit.exercise.greet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GreeterPartialTest {

    Greeter greeter = new Greeter();

    @Test
    void emptyName (){
        List<String> listaName = new ArrayList<>();

        String result = greeter.prepareScreamingHello(listaName);

        Assertions.assertEquals("", result);
    }

    @Test
    void oneName (){
        List<String> listaName = new ArrayList<>(1);
        listaName.add("ALICJA");

        String result = greeter.prepareScreamingHello(listaName);

        Assertions.assertEquals("HELLO ALICJA!", result);
    }

    @Test
    void twoName (){
        List<String> listaName = new ArrayList<>();
        listaName.add("MAGDA");
        listaName.add("MAKSYMILIAN");

        String result = greeter.prepareScreamingHello(listaName);

        Assertions.assertEquals("HELLO MAGDA AND MAKSYMILIAN!", result);
    }

    @Test
    void moreThanTwo(){
        List<String> listaName = new ArrayList<>();
        listaName.add("MAGDA");
        listaName.add("MAKS");
        listaName.add("PAWEŁ");
        listaName.add("JAN");

        String result = greeter.prepareScreamingHello(listaName);

        Assertions.assertEquals("HELLO MAGDA, MAKS, PAWEŁ AND JAN!", result);
    }

    @ParameterizedTest
    @MethodSource({"prepareParameters"})
    void emptyList(String expectedValue,List<String>listName){

        String result = greeter.prepareRegularHello(listName);

        Assertions.assertEquals(expectedValue,result);
    }
    static Stream<Arguments>prepareParameters(){
        return Stream.of(
                Arguments.arguments("",new ArrayList<>()),
                Arguments.arguments("Hello andrzej.", Arrays.asList("andrzej")),
                Arguments.arguments("Hello andrzej and weronika.", Arrays.asList("andrzej","weronika")),
                Arguments.arguments("Hello andrzej, weronika, tomek and alicja.", Arrays.asList("andrzej", "weronika", "tomek", "alicja")),
                Arguments.arguments("Hello AndrzeJ, weRonikA and TOMek.", Arrays.asList("AndrzeJ", "weRonikA", "TOMek"))
        );
    }
}
