package hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SomeInterviewQuestions {

    public static char firstNonRepeatingChar(String input) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = input.toCharArray();
        for (char ch : chars) {
            int count = charMap.containsKey(ch) ? charMap.get(ch) : 0;
            charMap.put(ch, count + 1);
        }
        for (char ch : chars) {
            if (charMap.get(ch) == 1 && ch != ' ') {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }

    public static char firstRepeatingChar(String input) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (charSet.contains(ch) && ch != ' ') {
                return ch;
            }
            charSet.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
