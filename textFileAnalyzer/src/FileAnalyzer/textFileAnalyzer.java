package FileAnalyzer;

import java.io.*;
import java.util.*;

public class textFileAnalyzer {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the full path of the text file: ");
        String filePath = scanner.nextLine();

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();  // Does not include line break characters

                String[] words = line.split("\\W+"); // Split on non-word characters

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount++;
                        word = word.toLowerCase(); // Make case-insensitive
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort and find top 5 most frequent words
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFrequency.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Output
        System.out.println("File: " + filePath);
        System.out.println("Total Lines     : " + lineCount);
        System.out.println("Total Words     : " + wordCount);
        System.out.println("Total Characters: " + charCount);
        System.out.println("\nTop 5 Most Frequent Words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println((i + 1) + ". " + sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue() + " times");
        }
        scanner.close();
    }
}
