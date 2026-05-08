import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> wordCounts = new HashMap<>();

        System.out.println("Enter text line by line.");
        System.out.println("Type 'exit' on a new line to finish and see word frequencies:");

        while (true) {
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            line = line.toLowerCase();
            line = line.replaceAll("[.,!?;:()\"']", "");

            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    if (wordCounts.containsKey(word)) {
                        wordCounts.put(word, wordCounts.get(word) + 1);
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
            }
        }

        TreeMap<String, Integer> sortedWords = new TreeMap<>(wordCounts);

        System.out.println("\nWord Frequencies:");
        for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}