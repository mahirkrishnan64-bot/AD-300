import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class WaitingListManager {
    private Queue<String> waitingQueue;
    private Set<String> waitingSet;

    public WaitingListManager() {
        waitingQueue = new LinkedList<>();
        waitingSet = new HashSet<>();
    }

    public void addPerson(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name. Please enter a non-empty name.");
            return;
        }

        name = name.trim();

        if (waitingSet.contains(name)) {
            System.out.println(name + " is already in the waiting list.");
        } else {
            waitingQueue.add(name);
            waitingSet.add(name);
            System.out.println(name + " has been added to the waiting list.");
        }
    }

    public String servePerson() {
        String servedPerson = waitingQueue.poll();

        if (servedPerson == null) {
            return "The waiting list is empty.";
        }

        waitingSet.remove(servedPerson);
        return servedPerson + " has been served.";
    }

    public boolean isPersonInList(String name) {
        if (name == null) {
            return false;
        }
        return waitingSet.contains(name.trim());
    }

    public int waitingListSize() {
        return waitingQueue.size();
    }

    public void displayWaitingList() {
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting list is empty.");
            return;
        }

        System.out.println("Current waiting list:");
        for (String person : waitingQueue) {
            System.out.println("- " + person);
        }
    }

    public static void main(String[] args) {
        WaitingListManager manager = new WaitingListManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Waiting List Menu ===");
            System.out.println("1. Add person");
            System.out.println("2. Serve person");
            System.out.println("3. Check if person is in list");
            System.out.println("4. Show waiting list size");
            System.out.println("5. Display waiting list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name to add: ");
                    String addName = scanner.nextLine();
                    manager.addPerson(addName);
                    break;

                case "2":
                    System.out.println(manager.servePerson());
                    break;

                case "3":
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    if (manager.isPersonInList(searchName)) {
                        System.out.println(searchName + " is in the waiting list.");
                    } else {
                        System.out.println(searchName + " is not in the waiting list.");
                    }
                    break;

                case "4":
                    System.out.println("Waiting list size: " + manager.waitingListSize());
                    break;

                case "5":
                    manager.displayWaitingList();
                    break;

                case "6":
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}