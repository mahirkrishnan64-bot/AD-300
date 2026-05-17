import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class IteratorCollection {

    public static void main(String[] args) {
        System.out.println("========== TASK 1: ARRAYLIST WITH ITERATOR ==========");
        task1ArrayList();

        System.out.println("\n========== TASK 2: HASHMAP WITH ITERATOR ==========");
        task2HashMap();

        System.out.println("\n========== TASK 3: TREEMAP WITH ITERATOR ==========");
        task3TreeMap();

        System.out.println("\n========== NORMAL TEST CASES ==========");
        runNormalTests();

        System.out.println("\n========== EDGE TEST CASES ==========");
        runEdgeTests();
    }

    // Task 1
    public static void task1ArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println("Original ArrayList: " + numbers);

        Iterator<Integer> iterator = numbers.iterator();
        int sum = 0;

        System.out.println("Iterating through ArrayList:");
        while (iterator.hasNext()) {
            int value = iterator.next();
            System.out.println("Value: " + value);
            sum += value;
        }

        System.out.println("Total sum: " + sum);

        ArrayList<Integer> removeDemo = new ArrayList<>(numbers);
        Iterator<Integer> removeIterator = removeDemo.iterator();

        System.out.println("\nRemoving even numbers safely using iterator.remove():");
        while (removeIterator.hasNext()) {
            int value = removeIterator.next();
            if (value % 2 == 0) {
                System.out.println("Removing: " + value);
                removeIterator.remove();
            }
        }
        System.out.println("List after iterator.remove(): " + removeDemo);

        ArrayList<Integer> addRemoveDemo = new ArrayList<>(numbers);

        System.out.println("\nAttempting list modification during iteration using list.add() / list.remove():");
        try {
            Iterator<Integer> badIterator = addRemoveDemo.iterator();
            while (badIterator.hasNext()) {
                int value = badIterator.next();
                System.out.println("Visiting: " + value);

                if (value % 2 != 0) {
                    addRemoveDemo.remove(Integer.valueOf(value));
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException when using list.remove() during iteration.");
        }

        try {
            Iterator<Integer> badIterator2 = addRemoveDemo.iterator();
            while (badIterator2.hasNext()) {
                int value = badIterator2.next();
                System.out.println("Visiting: " + value);

                if (value > 50) {
                    addRemoveDemo.add(999);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException when using list.add() during iteration.");
        }

        System.out.println("Final list after failed modifications: " + addRemoveDemo);

        System.out.println("\nObservation:");
        System.out.println("- iterator.remove() safely removes the current element.");
        System.out.println("- Using ArrayList add/remove directly during iteration causes ConcurrentModificationException.");
    }

    // Task 2
    public static void task2HashMap() {
        HashMap<String, Integer> categories = new HashMap<>();
        categories.put("Books", 12);
        categories.put("Movies", 8);
        categories.put("Games", 15);
        categories.put("Music", 6);
        categories.put("Sports", 10);

        System.out.println("Original HashMap: " + categories);

        Iterator<Map.Entry<String, Integer>> iterator = categories.entrySet().iterator();

        System.out.println("\nIterating through HashMap entries:");
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());

            if (entry.getKey().equals("Books")) {
                entry.setValue(entry.getValue() + 3);
            }

            if (entry.getKey().equals("Movies")) {
                entry.setValue(entry.getValue() + 2);
            }

            if (entry.getKey().equals("Music")) {
                System.out.println("Removing entry safely: " + entry.getKey());
                iterator.remove();
            }
        }

        System.out.println("\nModified HashMap: " + categories);

        System.out.println("\nObservation:");
        System.out.println("- entrySet().iterator() allows access to both key and value.");
        System.out.println("- entry.setValue() safely updates values during iteration.");
        System.out.println("- iterator.remove() safely removes entries during iteration.");
    }

    // Task 3
    public static void task3TreeMap() {
        TreeMap<String, Double> temperatures = new TreeMap<>();
        temperatures.put("January", 30.5);
        temperatures.put("March", 45.2);
        temperatures.put("May", 60.8);
        temperatures.put("July", 75.4);
        temperatures.put("September", 68.1);
        temperatures.put("November", 50.0);

        System.out.println("TreeMap contents (sorted by month key):");
        Iterator<Map.Entry<String, Double>> iterator = temperatures.entrySet().iterator();

        String highestMonth = "";
        String lowestMonth = "";
        double highestTemp = Double.NEGATIVE_INFINITY;
        double lowestTemp = Double.POSITIVE_INFINITY;

        while (iterator.hasNext()) {
            Map.Entry<String, Double> entry = iterator.next();
            String month = entry.getKey();
            double temp = entry.getValue();

            System.out.println(month + " -> " + temp);

            if (temp > highestTemp) {
                highestTemp = temp;
                highestMonth = month;
            }

            if (temp < lowestTemp) {
                lowestTemp = temp;
                lowestMonth = month;
            }
        }

        System.out.println("\nHighest temperature: " + highestTemp + " in " + highestMonth);
        System.out.println("Lowest temperature: " + lowestTemp + " in " + lowestMonth);

        System.out.println("\nObservation:");
        System.out.println("- TreeMap keeps keys sorted using natural ordering.");
        System.out.println("- Iterating over entrySet() processes entries in sorted key order.");
    }

    // Normal test cases
    public static void runNormalTests() {
        System.out.println("Test 1: ArrayList sum with known values");
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(10);
        testList.add(20);
        testList.add(30);

        int sum = 0;
        Iterator<Integer> iterator1 = testList.iterator();
        while (iterator1.hasNext()) {
            sum += iterator1.next();
        }
        System.out.println("Expected sum: 60");
        System.out.println("Actual sum: " + sum);

        System.out.println("\nTest 2: HashMap value update");
        HashMap<String, Integer> testMap = new HashMap<>();
        testMap.put("Books", 5);
        testMap.put("Movies", 3);

        Iterator<Map.Entry<String, Integer>> iterator2 = testMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Integer> entry = iterator2.next();
            if (entry.getKey().equals("Books")) {
                entry.setValue(10);
            }
        }
        System.out.println("Expected Books value: 10");
        System.out.println("Actual Books value: " + testMap.get("Books"));

        System.out.println("\nTest 3: TreeMap highest and lowest values");
        TreeMap<String, Double> tempMap = new TreeMap<>();
        tempMap.put("April", 55.0);
        tempMap.put("August", 80.0);
        tempMap.put("December", 35.0);

        String highMonth = "";
        String lowMonth = "";
        double high = Double.NEGATIVE_INFINITY;
        double low = Double.POSITIVE_INFINITY;

        Iterator<Map.Entry<String, Double>> iterator3 = tempMap.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry<String, Double> entry = iterator3.next();
            if (entry.getValue() > high) {
                high = entry.getValue();
                highMonth = entry.getKey();
            }
            if (entry.getValue() < low) {
                low = entry.getValue();
                lowMonth = entry.getKey();
            }
        }

        System.out.println("Expected highest: 80.0 in August");
        System.out.println("Actual highest: " + high + " in " + highMonth);
        System.out.println("Expected lowest: 35.0 in December");
        System.out.println("Actual lowest: " + low + " in " + lowMonth);
    }

    // Edge test cases
    public static void runEdgeTests() {
        System.out.println("Edge Test 1: Empty ArrayList");
        ArrayList<Integer> emptyList = new ArrayList<>();
        Iterator<Integer> iterator1 = emptyList.iterator();
        int sum = 0;
        while (iterator1.hasNext()) {
            sum += iterator1.next();
        }
        System.out.println("Expected sum: 0");
        System.out.println("Actual sum: " + sum);

        System.out.println("\nEdge Test 2: Empty HashMap");
        HashMap<String, Integer> emptyMap = new HashMap<>();
        Iterator<Map.Entry<String, Integer>> iterator2 = emptyMap.entrySet().iterator();
        if (!iterator2.hasNext()) {
            System.out.println("HashMap is empty, no entries to iterate.");
        }

        System.out.println("\nEdge Test 3: Empty TreeMap");
        TreeMap<String, Double> emptyTreeMap = new TreeMap<>();
        Iterator<Map.Entry<String, Double>> iterator3 = emptyTreeMap.entrySet().iterator();
        if (!iterator3.hasNext()) {
            System.out.println("TreeMap is empty, no temperature data available.");
        }

        System.out.println("\nEdge Test 4: Remove all values from ArrayList using iterator");
        ArrayList<Integer> smallList = new ArrayList<>();
        smallList.add(1);
        smallList.add(2);

        Iterator<Integer> iterator4 = smallList.iterator();
        while (iterator4.hasNext()) {
            iterator4.next();
            iterator4.remove();
        }

        System.out.println("Expected list: []");
        System.out.println("Actual list: " + smallList);
    }
}