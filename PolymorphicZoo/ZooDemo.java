package zoo;

import java.util.ArrayList;

public class ZooDemo {
    public static void main(String[] args) {
        ArrayList<Animal> zoo = new ArrayList<>();

        zoo.add(new Lion("Leo"));
        zoo.add(new Elephant("Ella"));
        zoo.add(new Monkey("Momo"));

        System.out.println("===== NORMAL TEST CASES =====");

        // Normal Test Case 1
        System.out.println("\nTest Case 1: Lion makes one sound");
        Animal lion = new Lion("Leo");
        lion.makeSound();

        // Normal Test Case 2
        System.out.println("\nTest Case 2: Elephant makes sound 3 times");
        Animal elephant = new Elephant("Ella");
        elephant.makeSound(3);

        // Normal Test Case 3
        System.out.println("\nTest Case 3: Monkey makes sound 2 times");
        Animal monkey = new Monkey("Momo");
        monkey.makeSound(2);

        System.out.println("\n===== POLYMORPHISM LOOP TEST =====");
        for (Animal animal : zoo) {
            System.out.println("\nAnimal: " + animal.getName());
            animal.makeSound();
            animal.makeSound(2);
        }

        System.out.println("\n===== EDGE TEST CASES =====");

        // Edge Test Case 1: times = 0
        System.out.println("\nEdge Case 1: Lion with 0 times");
        lion.makeSound(0);

        // Edge Test Case 2: times = negative number
        System.out.println("\nEdge Case 2: Elephant with -2 times");
        elephant.makeSound(-2);

        // Edge Test Case 3: empty name
        System.out.println("\nEdge Case 3: Monkey with empty name");
        Animal monkeyEmpty = new Monkey("");
        System.out.println("Animal name: '" + monkeyEmpty.getName() + "'");
        monkeyEmpty.makeSound();

        // Optional extra edge case
        System.out.println("\nEdge Case 4: Lion with 1 time");
        lion.makeSound(1);
    }
}