package string_manipulation_algorithms;

import java.util.Arrays;
import java.util.List;

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
}
