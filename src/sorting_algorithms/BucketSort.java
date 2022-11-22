package sorting_algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] input, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(i, new ArrayList<>());
        }

        for (int item : input) {
            int bucketNumber = item / numberOfBuckets;
            buckets.get(bucketNumber).add(item);
        }

        int i = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int item : bucket) {
                input[i] = item;
                i++;
            }
        }
    }
}
