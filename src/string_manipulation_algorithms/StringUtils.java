package string_manipulation_algorithms;

import java.util.*;

public class StringUtils {
    private static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    public static int countVowels(String input) {
        int count = 0;
        for (char ch : input.toLowerCase().toCharArray()) {
            if (vowels.contains(ch)) {
                count++;
            }
        }
        return count;
    }

    public static String reverseString(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String reverseOrderOfWords(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = input.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static boolean areRotations(String str1, String str2) {
        return (str1.length() != str2.length() &&
                (str1+str1).contains(str2));
    }

    public static String removeDuplicates(String input) {
        Set<Character> seen = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static char mostRepeatedChar(String input) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char ch : input.toCharArray()) {
            int count = (frequencies.containsKey(ch) ? frequencies.get(ch) : 0);
            frequencies.put(ch, count + 1);
        }
        int max = -1;
        char result = input.charAt(0);
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            if (entry.getKey() != ' ' && entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static String capitalize(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        String[] words = input
                           .trim()
                           .replaceAll(" +",  " ")
                           .split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() +
                    words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null || first.length() != second.length()) {
            return false;
        }
        char[] array1 = first.toCharArray();
        char[] array2 = second.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

        /*StringBuilder input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);*/
    }
}
