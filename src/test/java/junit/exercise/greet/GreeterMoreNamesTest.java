package junit.exercise.greet;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreeterMoreNamesTest {

    Greeter greeter = new Greeter();

    @Test
    void whenHaveThreeNamesLowerCase(){
        String [] listName = new String [] {"andrzej", "janek", "monika"};

        String result = greeter.greet(listName);

        Assertions.assertThat(result)
                .withFailMessage("Result test is failed names.")
                .isEqualTo("Hello andrzej, janek and monika.");
    }

    @Test
    void whenHaveThreeNamesUpperCase (){
        String [] listName = new String [] {"ANDRZEJ", "JANEK", "MONIKA"};

        String result = greeter.greet(listName);

        Assertions.assertThat(result)
                .withFailMessage("Result test is failed names.")
                .isEqualTo("HELLO ANDRZEJ, JANEK AND MONIKA!");

    }


}
