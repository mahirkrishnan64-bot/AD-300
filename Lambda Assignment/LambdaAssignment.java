import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaAssignment {

    // Task 2: Functional interface for math operations
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }

    // Task 5: Custom functional interface for string operations
    @FunctionalInterface
    interface StringOperation {
        String apply(String s1, String s2);
    }

    public static void main(String[] args) {
        System.out.println("=== Task 1: Runnable with Lambda ===");
        task1RunnableExample();

        System.out.println("\n=== Task 2: MathOperation with Lambdas ===");
        task2MathOperations();

        System.out.println("\n=== Task 3: Collections with Lambdas ===");
        task3Collections();

        System.out.println("\n=== Task 4: Built-in Functional Interfaces ===");
        task4BuiltInFunctionalInterfaces();

        System.out.println("\n=== Task 5: Advanced Usage ===");
        task5AdvancedUsage();

        System.out.println("\n=== Simple Test Cases (Normal + Edge) ===");
        runTests();
    }

    // Task 1: Runnable with lambda
    private static void task1RunnableExample() {
        // Traditional anonymous class:
        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running from anonymous class.");
            }
        };
        oldRunnable.run();

        // Lambda version:
        Runnable lambdaRunnable = () -> System.out.println("Running from lambda Runnable.");
        lambdaRunnable.run();
    }

    // Task 2: MathOperation with lambdas
    private static void task2MathOperations() {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                System.out.println("Warning: division by zero, returning 0.");
                return 0; // simple handling for demo
            }
            return a / b;
        };

        System.out.println("5 + 3 = " + add.operate(5, 3));
        System.out.println("5 - 3 = " + subtract.operate(5, 3));
        System.out.println("5 * 3 = " + multiply.operate(5, 3));
        System.out.println("10 / 2 = " + divide.operate(10, 2));
        System.out.println("10 / 0 (edge) = " + divide.operate(10, 0));
    }

    // Task 3: Collections with lambdas
    private static void task3Collections() {
        // Sort a list of strings
        List<String> names = new ArrayList<>(Arrays.asList(
                "Zoe", "Adam", "mike", "Bob", "alice"
        ));
        System.out.println("Original names: " + names);
        // Case-insensitive sort using lambda
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted names (case-insensitive): " + names);

        // Filter a list of integers (keep only odd numbers)
        List<Integer> numbers = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 0, -1
        ));
        System.out.println("Original numbers: " + numbers);

        List<Integer> odds = new ArrayList<>();
        numbers.forEach(n -> {
            if (n % 2 != 0) {
                odds.add(n);
            }
        });
        System.out.println("Filtered (odd numbers): " + odds);
    }

    // Task 4: Built-in Predicate and Function
    private static void task4BuiltInFunctionalInterfaces() {
        // Predicate<String>: check if string is empty
        Predicate<String> isEmpty = s -> s == null || s.isEmpty();

        System.out.println("Predicate tests:");
        System.out.println("isEmpty(\"\") = " + isEmpty.test(""));
        System.out.println("isEmpty(\"hello\") = " + isEmpty.test("hello"));
        System.out.println("isEmpty(null) = " + isEmpty.test(null));

        // Function<String, String>: toUpperCase
        Function<String, String> toUpper = s -> s == null ? null : s.toUpperCase();

        System.out.println("\nFunction tests:");
        System.out.println("toUpper(\"java\") = " + toUpper.apply("java"));
        System.out.println("toUpper(\"\") = \"" + toUpper.apply("") + "\"");
        System.out.println("toUpper(null) = " + toUpper.apply(null));
    }

    // Task 5: Advanced usage
    private static void task5AdvancedUsage() {
        // Compose functions: add1 and multiplyBy10
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> multiplyBy10 = x -> x * 10;

        Function<Integer, Integer> add1ThenMultiplyBy10 = add1.andThen(multiplyBy10);

        int input = 5;
        int result = add1ThenMultiplyBy10.apply(input); // (5 + 1) * 10 = 60
        System.out.println("Composed function (add1 then *10) on " + input + " = " + result);

        // Custom functional interface: StringOperation
        StringOperation concat = (s1, s2) -> {
            if (s1 == null) s1 = "";
            if (s2 == null) s2 = "";
            return s1 + s2;
        };

        StringOperation longer = (s1, s2) -> {
            if (s1 == null) return s2;
            if (s2 == null) return s1;
            return s1.length() >= s2.length() ? s1 : s2;
        };

        System.out.println("Concat(\"Hello\", \" World\") = " + concat.apply("Hello", " World"));
        System.out.println("Longer(\"short\", \"longerString\") = " + longer.apply("short", "longerString"));
        System.out.println("Longer(null, \"onlyOne\") = " + longer.apply(null, "onlyOne"));
    }

    // Simple test cases (3 normal + 3 edge-ish)
    private static void runTests() {
        // Normal test 1: MathOperation add
        MathOperation add = (a, b) -> a + b;
        System.out.println("Test 1 (normal) add(2,3)==5: " + (add.operate(2, 3) == 5));

        // Normal test 2: Predicate isEmpty for empty string
        Predicate<String> isEmpty = s -> s == null || s.isEmpty();
        System.out.println("Test 2 (normal) isEmpty(\"\")==true: " + isEmpty.test(""));

        // Normal test 3: Function composition (add1ThenMultiplyBy10)
        Function<Integer, Integer> add1 = x -> x + 1;
        Function<Integer, Integer> multiplyBy10 = x -> x * 10;
        Function<Integer, Integer> composed = add1.andThen(multiplyBy10);
        System.out.println("Test 3 (normal) composed(5)==60: " + (composed.apply(5) == 60));

        // Edge test 1: Division by zero for MathOperation divide
        MathOperation divide = (a, b) -> {
            if (b == 0) return 0;
            return a / b;
        };
        System.out.println("Edge 1 divide(10,0)==0: " + (divide.operate(10, 0) == 0));

        // Edge test 2: Predicate isEmpty with null
        System.out.println("Edge 2 isEmpty(null)==true: " + isEmpty.test(null));

        // Edge test 3: StringOperation concat with nulls
        StringOperation concat = (s1, s2) -> {
            if (s1 == null) s1 = "";
            if (s2 == null) s2 = "";
            return s1 + s2;
        };
        System.out.println("Edge 3 concat(null, \"x\").equals(\"x\"): " +
                "x".equals(concat.apply(null, "x")));
    }
}