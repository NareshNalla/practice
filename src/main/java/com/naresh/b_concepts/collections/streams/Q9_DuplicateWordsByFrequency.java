package com.naresh.b_concepts.collections.streams;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 🔹 Q9. Given a sentence, how do you find duplicate words along with their
 * occurrence count, sorted by frequency in descending order?
 */
public class Q9_DuplicateWordsByFrequency {
    private static final Pattern SPLIT_NON_WORD = Pattern.compile("\\W+");
    public static void main(String[] args) {
        String sentence = "Java is great and Java is popular and Java is powerful";

        // Logic:
        // Logic: Consistent tokenization and case-insensitivity
        SPLIT_NON_WORD.splitAsStream(sentence)
                .filter(s -> !s.isBlank())
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.print(entry.getKey() + "=" + entry.getValue() + " "));
        System.out.println();

        //find first duplicate
        Set<String> seen = new HashSet<>();
        Optional<String> firstDuplicate = SPLIT_NON_WORD.splitAsStream(sentence)
                .filter(s -> !s.isBlank())
                .map(s -> s.toLowerCase(Locale.ROOT))
                .filter(word -> !seen.add(word))
                .findFirst();
        firstDuplicate.ifPresent(d -> System.out.println("\nFirst duplicate: " + d));


        //most frequent word
        System.out.println(mostFrequentWordsByStream(sentence));

        System.out.println("Single most frequent: " + mostFrequentWord(sentence));

    }

    public static String mostFrequentWord(String sentence) {
        if (sentence == null || sentence.isBlank()) return "";

        return SPLIT_NON_WORD.splitAsStream(sentence)
                .filter(s -> !s.isBlank())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
    // Returns list of most frequent words (lowercased). If tie, returns all tied words.
    public static List<String> mostFrequentWordsByStream(String sentence) {
        if (sentence == null || sentence.isBlank()) return Collections.emptyList();

        // 1) tokenize -> lower -> group & count
        Map<String, Long> freq = SPLIT_NON_WORD.splitAsStream(sentence)
                .filter(s -> !s.isBlank())
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (freq.isEmpty()) return Collections.emptyList();
        // 2) find max frequency
        long max = freq.values().stream().mapToLong(Long::longValue).max().orElse(0L);
        System.out.println("max freq: "+max);
        // 3) collect words with max frequency
        return freq.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
