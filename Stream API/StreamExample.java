import java.util.*;
import java.util.stream.Collectors;


public class StreamExample {

    public static void main(String[] args) {
        // Task 2: list of integers 1..10
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Task 3.1: filter even numbers and print
        System.out.println("Even numbers:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // Task 3.2: map to squares and print
        System.out.println("\nSquares:");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);

        // Task 3.3: filter odd numbers, then map to cubes
        System.out.println("\nOdd numbers cubed:");
        numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n * n)
                .forEach(System.out::println);

        // Task 4.1: reduce to sum all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("\nSum with reduce: " + sum);

        // Task 4.2: collect even numbers into a new list
        List<Integer> evenNumbers =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList());
        System.out.println("Even numbers list: " + evenNumbers);

        // Task 5.1: flatMap a list of lists into a single list
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9, 10)
        );

        List<Integer> flattened =
                listOfLists.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
        System.out.println("\nFlattened list: " + flattened);

        // Task 5.2: groupingBy even / odd
        Map<String, List<Integer>> groupedByParity =
                numbers.stream()
                        .collect(Collectors.groupingBy(
                                n -> (n % 2 == 0) ? "even" : "odd"
                        ));

        System.out.println("Grouped by parity: " + groupedByParity);

        // Task 6: Stream with custom objects
        List<Person> people = Arrays.asList(
                new Person("Alice", 23),
                new Person("Bob", 30),
                new Person("Charlie", 27),
                new Person("Diana", 19),
                new Person("Ethan", 42)
        );

        // Task 6.1: filter people older than 25 and print their names
        System.out.println("\nPeople older than 25:");
        people.stream()
                .filter(p -> p.getAge() > 25)
                .map(Person::getName)
                .forEach(System.out::println);

        // Task 6.2: find the oldest person
        Optional<Person> oldest =
                people.stream()
                        .max(Comparator.comparingInt(Person::getAge));

        oldest.ifPresent(p ->
                System.out.println("Oldest person: " + p.getName()
                        + " (" + p.getAge() + ")"));
    }
}