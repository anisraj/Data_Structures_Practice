package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SomeInterViewQuestions {

    public static String reverse(String input) {
        if (input == null) {
            throw  new IllegalArgumentException();
        }
        Stack<Character> characterStack = new Stack<>();
        for (char ch : input.toCharArray()) {
            characterStack.push(ch);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!characterStack.isEmpty()) {
            stringBuffer.append(characterStack.pop());
        }
        return stringBuffer.toString();
    }

    private static final List<Character> openingBrackets = Arrays.asList('(', '{', '<', '[');
    private static final List<Character> closingBrackets = Arrays.asList(')', '}', '>', ']');
    public static boolean isBalanced(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        Stack<Character> characterStack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (openingBrackets.contains(ch)) {
                characterStack.push(ch);
            }
            if (closingBrackets.contains(ch)) {
                if (characterStack.isEmpty()) return false;
                char top = characterStack.pop();
                if (closingBrackets.indexOf(ch) != openingBrackets.indexOf(top)) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
}
