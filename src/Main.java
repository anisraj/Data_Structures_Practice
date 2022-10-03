import arrays.Array;
import linked_lists.MyLinkedList;
import stack.MyStack;
import stack.SomeInterViewQuestions;
import stack.TwoStack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack(5);
        twoStack.push1(10);
        twoStack.push1(20);
        twoStack.push1(30);
        twoStack.push2(40);
        twoStack.push2(50);
        System.out.println(twoStack.pop2());
        System.out.println(twoStack.pop2());
    }
}