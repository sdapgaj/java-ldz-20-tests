package junit.exercise.greet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Greeter {

    public static String greet(String ...names) {
        if (names.length == 0 || (names.length == 1 && names[0] == null)) {
            return "Hello my friend.";
        }

        Map<Boolean, List<String>> groupedNames = Stream.of(names)
                .collect(Collectors.partitioningBy(Greeter::isAllCapital));

        List<String> namesInCapitals = groupedNames.get(true);
        String screamingHello = prepareScreamingHello(namesInCapitals);

        List<String> regularNames = groupedNames.get(false);
        String regularHello = prepareRegularHello(regularNames);

        String delimiter = !regularHello.isEmpty() && !screamingHello.isEmpty() ? " " : "";
        return regularHello + delimiter + screamingHello;
    }

    public static String prepareScreamingHello(List<String> namesInCapitals) {
        switch (namesInCapitals.size()) {
            case 0:
                return "";
            case 1:
                return "HELLO " + namesInCapitals.get(0) + "!";
            default:
                Integer lastNameIndex = namesInCapitals.size() - 1;
                return "HELLO " + String.join(", ", namesInCapitals.subList(0, lastNameIndex)) + " AND " + namesInCapitals.get(lastNameIndex) + "!";
        }
    }

    public static String prepareRegularHello(List<String> regularNames) {
        switch (regularNames.size()) {
            case 0:
                return "";
            case 1:
                return "Hello " + regularNames.get(0) + ".";
            default:
                Integer lastNameIndex = regularNames.size() - 1;
                return "Hello " + String.join(", ", regularNames.subList(0, lastNameIndex)) + " and " + regularNames.get(lastNameIndex) + ".";
        }
    }

    private static boolean isAllCapital(String text) {
        return text.matches("^[A-Z]*$");
    }

}
