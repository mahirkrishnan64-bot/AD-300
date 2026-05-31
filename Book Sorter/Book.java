import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', year=" + year + "}";
    }

    public static void printBooks(String heading, List<Book> books) {
        System.out.println("\n" + heading);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("Animal Farm", "George Orwell", 1945));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932));
        books.add(new Book("Go Set a Watchman", "Harper Lee", 2015));

        printBooks("Original List:", books);

        Collections.sort(books);
        printBooks("Sorted by Title (Default Comparable):", books);

        Comparator<Book> authorComparator = Comparator.comparing(Book::getAuthor, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(books, authorComparator);
        printBooks("Sorted by Author:", books);

        Comparator<Book> yearComparator = (b1, b2) -> Integer.compare(b2.getYear(), b1.getYear());
        Collections.sort(books, yearComparator);
        printBooks("Sorted by Year (Newest First):", books);

        Comparator<Book> authorThenTitleComparator =
                Comparator.comparing(Book::getAuthor, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(books, authorThenTitleComparator);
        printBooks("Sorted by Author, Then Title:", books);
    }
}