// Main.java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Pair Demo ===");
        Pair<String, Integer> student = new Pair<>("Mahir", 101);
        System.out.println(student);
        student.setValue(202);
        System.out.println("Updated: " + student);

        System.out.println("\n=== Stack Demo ===");
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Generics");
        stack.push("Assignment");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is empty? " + stack.isEmpty());

        System.out.println("\n=== Sorting Demo ===");
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(5, 2, 9, 1));
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Ava", 22));
        people.add(new Person("Liam", 19));
        people.add(new Person("Noah", 25));

        GenericUtils.sort(intList);
        GenericUtils.sort(stringList);
        GenericUtils.sort(people);

        System.out.println("Sorted Integers: " + intList);
        System.out.println("Sorted Strings: " + stringList);
        System.out.println("Sorted People: " + people);

        System.out.println("\n=== printCollection Demo ===");
        GenericUtils.printCollection(stringList);

        System.out.println("\n=== sumOfNumberList Demo ===");
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4);
        List<Double> nums2 = Arrays.asList(2.5, 3.5, 4.0);
        System.out.println("Sum ints: " + GenericUtils.sumOfNumberList(nums1));
        System.out.println("Sum doubles: " + GenericUtils.sumOfNumberList(nums2));

        System.out.println("\n=== Cache Demo ===");
        Cache<Number> numberCache = new Cache<>();
        Cache<Integer> integerCache = new Cache<>();

        integerCache.add("a", 10);
        integerCache.add("b", 20);

        numberCache.add("pi", 3.14);
        numberCache.addAll(integerCache);

        System.out.println("Integer cache: " + integerCache);
        System.out.println("Number cache after addAll: " + numberCache);
        System.out.println("Get 'a': " + numberCache.get("a"));

        numberCache.clear();
        System.out.println("Cleared cache size: " + numberCache.size());

        System.out.println("\n=== Edge Case Demo ===");
        Stack<Integer> emptyStack = new Stack<>();
        try {
            emptyStack.pop();
        } catch (Exception e) {
            System.out.println("Caught exception when popping empty stack: " + e);
        }

        ArrayList<Integer> emptyList = new ArrayList<>();
        GenericUtils.sort(emptyList);
        System.out.println("Sorted empty list: " + emptyList);

        List<Integer> emptyNums = Arrays.asList();
        System.out.println("Sum empty list: " + GenericUtils.sumOfNumberList(emptyNums));
    }
}