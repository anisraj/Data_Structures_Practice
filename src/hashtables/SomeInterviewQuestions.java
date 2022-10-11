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

    public static int mostRepeatedElement(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : input) {
            int count = map.containsKey(item) ? map.get(item) : 0;
            map.put(item, count + 1);
        }
        int max = 0;
        int resource = -1;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                resource = item.getKey();
            }
        }
        return resource;
    }
}
