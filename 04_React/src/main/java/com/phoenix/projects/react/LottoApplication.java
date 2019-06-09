package com.phoenix.projects.react;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LottoApplication {

    private static final Logger logger = LoggerFactory.getLogger(LottoApplication.class);
    private static final int[] prevWeek = {6,13,21,24,32,47};

    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 1, n, 0);
        return combinations;
    }

    private void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    /*
     * return true if the array is not a candidate of probable winning numbers
     */
    public boolean filter(int[] array) {                                  // All Permutation: 13,983,816

        if (isConsecutive(array, 3)) return true;
        if (isAllEvenOrOdd(array, 2)) return true;
        if (isConcentrated(array, 10, 3)) return true;
        if (isAverageExceedLimit(array, 16, 30)) return true;
        if (isSumExceedLimit(array, 125, 230)) return true;
        if (isExceedModulus(array, 10, 2)) return true;
        if (isExceedPopularNumbers(array, 31, 1, 3)) return true;
        if (isRepeatsExceedLimit(prevWeek, array, 1)) return true;

        return false;
    }

    public boolean isConsecutive(int[] array, int limit) {

        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 == (array[i+1])) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter == limit - 1) {
                //logger.debug("Dropping: " + Arrays.toString(array));
                return true;
            }
        }
        //logger.debug("Keeping: " + Arrays.toString(array));
        return false;
    }

    public boolean isAllEvenOrOdd(int[] array, int nbrOfException) {

        if (array == null || array.length == 0) return false;

        int counter = 0;
        for (int num : array) {
            if (array[0]%2 != num%2) {
                counter++;
                if (counter > nbrOfException) return false;
            }
        }
        return true;
    }

    public boolean isConcentrated(int[] array, int multiple, int limit) {

        int counter = 0;
        int factor = 0;
        boolean limitReach = false;
        for (int num : array) {
            if (factor == num / multiple) {
                counter++;
            } else {
                factor = num / multiple;
                counter = 1;
            }

            if (!limitReach && counter == limit)
                limitReach = true;
            else if (limitReach && counter == limit)
                return true;

            if (counter > limit)
                return true;
        }
        return false;
    }

    public boolean isSumExceedLimit(int[] array, int min, int max) {

        int sum = Arrays.stream(array).sum();
        return (sum < min || sum > max);
    }

    public boolean isAverageExceedLimit(int[] array, int min, int max) {

        long avg = Math.round(Arrays.stream(array).average().getAsDouble());
        return (avg < min || avg > max);
    }

    public boolean isExceedModulus(int[] array, int modulus, int limit) {

        boolean limitReach = false;
        int[] counters = new int[modulus];
        for (int num : array) {
            counters[num % modulus]++;
        }

        for (int count : counters) {
            if (count > limit) return true;

            if (!limitReach && count == limit) {
                limitReach = true;
            } else if (limitReach && count == limit) {
                return true;
            }
        }

        return false;
    }


    public boolean isRepeatsExceedLimit(int[] a, int[] b, int limit) {

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(Arrays.stream(a).boxed().toArray(Integer[]::new)));
        set.addAll(Arrays.asList(Arrays.stream(b).boxed().toArray(Integer[]::new)));

        return set.size() < a.length + b.length - limit;
    }

    public boolean isExceedPopularNumbers(int[] array, int threshold, int min, int max) {

        int counter = 0;
        for (int num : array) {
            if (num > threshold) {
                counter++;
            }
        }
        if (counter < min || counter > max)
            return true;

        return false;
    }
}
