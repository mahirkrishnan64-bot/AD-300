import java.util.ArrayList;
import java.util.List;

// Part 1: Generic Class
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    // Generic method that can print any Box of any type
    public static <U> void printBox(Box<U> box) {
        System.out.println("Box contains: " + box.get());
    }

    // Wildcard version for any kind of box
    public static void printAnyBox(Box<?> box) {
        System.out.println("Any box contains: " + box.get());
    }

    // Upper-bounded wildcard: works with NumberBox of Number subtypes
    public static void printNumberBox(NumberBox<? extends Number> box) {
        System.out.println("Number box contains: " + box.get());
    }
}

// Part 1: Bounded Type Parameters
class NumberBox<T extends Number> extends Box<T> {
    public double doubleValue() {
        return get().doubleValue();
    }
}

// Part 2: Generic Interface
interface Processor<T> {
    T process(T input);
}

// Part 2: Interface Implementation
class StringProcessor implements Processor<String> {
    @Override
    public String process(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }
}

// Part 3: Library item interface so different item types can be searched by name
interface Nameable {
    String getName();
}

class Book implements Nameable {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', author='" + author + "'}";
    }
}

class DVD implements Nameable {
    private String name;
    private int durationMinutes;

    public DVD(String name, int durationMinutes) {
        this.name = name;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DVD{name='" + name + "', duration=" + durationMinutes + " mins}";
    }
}

// Part 3: Practical Application
class Library<T extends Nameable> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(String name) {
        return items.removeIf(item -> item.getName().equalsIgnoreCase(name));
    }

    public T findItemByName(String name) {
        for (T item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Part 1: Box with different types
        Box<Integer> intBox = new Box<>();
        intBox.set(123);

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");

        System.out.println("Integer box value: " + intBox.get());
        System.out.println("String box value: " + stringBox.get());

        Box.printBox(intBox);
        Box.printBox(stringBox);

        Box.printAnyBox(intBox);
        Box.printAnyBox(stringBox);

        // NumberBox with numeric types
        NumberBox<Integer> numberIntBox = new NumberBox<>();
        numberIntBox.set(50);

        NumberBox<Double> numberDoubleBox = new NumberBox<>();
        numberDoubleBox.set(25.75);

        System.out.println("Integer NumberBox double value: " + numberIntBox.doubleValue());
        System.out.println("Double NumberBox double value: " + numberDoubleBox.doubleValue());

        Box.printNumberBox(numberIntBox);
        Box.printNumberBox(numberDoubleBox);

        // This causes a compile-time error, so leave it commented:
        // NumberBox<String> invalidBox = new NumberBox<>();

        // Part 2: Generic Interface
        StringProcessor processor = new StringProcessor();
        String original = "Java";
        String reversed = processor.process(original);

        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed);

        // Part 3: Library with books
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.addItem(new Book("1984", "George Orwell"));
        bookLibrary.addItem(new Book("The Hobbit", "J.R.R. Tolkien"));

        System.out.println("\nBook Library:");
        bookLibrary.printItems();

        System.out.println("Find '1984': " + bookLibrary.findItemByName("1984"));
        System.out.println("Remove '1984': " + bookLibrary.removeItem("1984"));
        System.out.println("Find '1984' after removal: " + bookLibrary.findItemByName("1984"));

        // Library with DVDs
        Library<DVD> dvdLibrary = new Library<>();
        dvdLibrary.addItem(new DVD("Inception", 148));
        dvdLibrary.addItem(new DVD("Interstellar", 169));

        System.out.println("\nDVD Library:");
        dvdLibrary.printItems();

        System.out.println("Find 'Inception': " + dvdLibrary.findItemByName("Inception"));
    }
}