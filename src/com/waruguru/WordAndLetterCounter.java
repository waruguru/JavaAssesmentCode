package com.waruguru;

import java.util.*;

public class WordAndLetterCounter {

    public static void main(String[] args) {
        String[] fruits = args.length != 0 ? args : new String[]{"Apple", "Apricot", "Cherry", "Banana", "Cherry", "Papaya", "Cantaloupe"};

        System.out.println(startProgram(fruits));
    }

    public static StringBuilder startProgram(String[] fruits) {

        Map<Character, List<String>> dictionary = new HashMap<>();

        // Build Dictionary, A-Z
        for (char i = 'A'; i <= 'Z'; i++)
            dictionary.put(i, new ArrayList<>());

        System.out.print("Do you want to display Fruits Count? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();

        StringBuilder output;

        if ("Y".equalsIgnoreCase(answer)) {
            output = matchLetterCountToWords(mapDictionary(fruits, dictionary));
        } else if ("N".equalsIgnoreCase(answer)) {
            output = countFirstLetter(mapDictionary(fruits, dictionary));
        } else {
            output = new StringBuilder("Invalid input");
        }

        return output;
    }

    public static StringBuilder countFirstLetter(Map<Character, List<String>> mappedDictionary) {
        StringBuilder response = new StringBuilder();
        for (Map.Entry<Character, List<String>> entry : mappedDictionary.entrySet())
            response
                    .append(entry.getKey().toString())
                    .append(": ")
                    .append(entry.getValue().size())
                    .append("\n");

        return response;
    }

    public static StringBuilder matchLetterCountToWords(Map<Character, List<String>> mappedDictionary) {
        StringBuilder response = new StringBuilder();

        for (Map.Entry<Character, List<String>> entry : mappedDictionary.entrySet()) {
            response
                    .append(entry.getKey().toString())
                    .append(": ")
                    .append(entry.getValue().size())
                    .append("\n");

            Map<String, Integer> fruitCount = new HashMap<>();
            for (String fruit : entry.getValue()) {
                Integer count = fruitCount.getOrDefault(fruit, 0);
                count++;
                fruitCount.put(fruit, count);
            }

            for (Map.Entry<String, Integer> fruitCountEntry : fruitCount.entrySet()) {
                int size = fruitCountEntry.getValue();
                response
                        .append(size)
                        .append(" ")
                        .append(fruitCountEntry.getKey())
                        .append((size == 1 ? "" : "s"))
                        .append("\n");
            }
        }

        return response;
    }

    public static Map<Character, List<String>> mapDictionary(String[] strings, Map<Character, List<String>> dictionary) {
        for (String s : strings) {
            char c = s.charAt(0);
            List<String> array = dictionary.get(c);
            array.add(s);
            dictionary.put(c, array);
        }
        return dictionary;
    }
}
