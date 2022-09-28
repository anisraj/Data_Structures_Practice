import arrays.Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(80);
        array.insert(30);
        array.insert(40);
        array.insertAt(21, 1);
        array.print();
    }
}