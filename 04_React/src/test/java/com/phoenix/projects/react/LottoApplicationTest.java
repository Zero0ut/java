package com.phoenix.projects.react;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoApplicationTest {


    @Test
    public void test_isConsecutive() {

        LottoApplication app = new LottoApplication();

        int ex1[] = {4, 6, 8, 10, 11, 12};
        int ex2[] = {4, 5, 6, 10, 11, 15};
        int ex3[] = {4, 5, 21, 22, 23, 28};
        int ex4[] = {4, 5, 21, 22, 23, 24};

        int ex5[] = {4, 6, 8, 10, 11, 13};
        int ex6[] = {4, 6, 21, 22, 24, 28};
        int ex7[] = {10, 12, 13, 15, 16, 18};
        int ex8[] = {10, 12, 13, 15, 16, 17};
        int ex9[] = {3, 8, 24, 27, 28, 49};

        assertTrue(app.isConsecutive(ex1, 3));
        assertTrue(app.isConsecutive(ex2, 3));
        assertTrue(app.isConsecutive(ex3, 3));
        assertTrue(app.isConsecutive(ex4, 4));

        assertFalse(app.isConsecutive(ex5, 3));
        assertFalse(app.isConsecutive(ex6, 3));
        assertFalse(app.isConsecutive(ex7, 3));
        assertFalse(app.isConsecutive(ex8, 4));
        assertFalse(app.isConsecutive(ex9, 3));

    }

    @Test
    public void test_isAllEvenOrOdd() {

        LottoApplication app = new LottoApplication();

        int ex1[] = {22, 26, 30, 36, 40, 48};
        int ex2[] = {13, 23, 27, 39, 47, 49};
        int ex3[] = {4, 6, 8, 10, 12, 13};
        int ex4[] = {22, 26, 30, 36, 43, 45};

        int ex5[] = {22, 26, 30, 36, 43, 45};
        int ex6[] = {1, 2, 3, 4, 5, 6};
        int ex7[] = {22, 26, 30, 31, 43, 45};
        int ex8[] = {3, 8, 24, 27, 28, 49};

        assertTrue(app.isAllEvenOrOdd(ex1, 1));
        assertTrue(app.isAllEvenOrOdd(ex2, 1));
        assertTrue(app.isAllEvenOrOdd(ex3, 1));
        assertTrue(app.isAllEvenOrOdd(ex4, 2));

        assertFalse(app.isAllEvenOrOdd(ex5, 1));
        assertFalse(app.isAllEvenOrOdd(ex6, 1));
        assertFalse(app.isAllEvenOrOdd(ex7, 2));
        assertFalse(app.isAllEvenOrOdd(ex8, 2));
    }

    @Test
    public void test_isConcentrated() {

        LottoApplication app = new LottoApplication();

        int ex1[] = {11, 15, 16, 17, 20, 31};
        int ex2[] = {11, 15, 16, 17, 18, 21};
        int ex3[] = {11, 15, 16, 22, 23, 28};
        int ex4[] = {11, 15, 16, 22, 23, 38};
        int ex5[] = {3, 8, 24, 27, 28, 49};

        assertTrue(app.isConcentrated(ex1, 10, 3));
        assertTrue(app.isConcentrated(ex2, 10, 3));
        assertTrue(app.isConcentrated(ex3, 10, 3));
        assertFalse(app.isConcentrated(ex4, 10, 3));
        assertFalse(app.isConcentrated(ex5, 10, 3));
    }

    @Test
    public void test_isSumExceedLimit() {

        LottoApplication app = new LottoApplication();

        int ex1[] = {1,4,7,23,37,38};
        int ex2[] = {1,4,7,23,37,39};
        int ex3[] = {29,34,38,42,44,47};
        int ex4[] = {29,34,38,42,44,46};

        int ex5[] = {1,4,7,23,37,37};
        int ex6[] = {29,34,38,42,44,48};
        int ex7[] = {3, 8, 24, 27, 28, 49};

        assertFalse(app.isSumExceedLimit(ex1, 110, 234));
        assertFalse(app.isSumExceedLimit(ex2, 110, 234));
        assertFalse(app.isSumExceedLimit(ex3, 110, 234));
        assertFalse(app.isSumExceedLimit(ex4, 110, 234));

        assertTrue(app.isSumExceedLimit(ex5, 110, 234));
        assertTrue(app.isSumExceedLimit(ex6, 110, 234));

        assertFalse(app.isSumExceedLimit(ex7, 110, 234));
    }
    @Test
    public void test_isAverageExceedLimit() {

        LottoApplication app = new LottoApplication();

        int ex1[] = {3,4,5,24,29,32};       // Avg: 16
        int ex2[] = {6,12,35,39,42,44};     // Avg: 30
        int ex3[] = {1,2,9,16,30,41};       // Avg: 17
        int ex4[] = {11,20,30,32,33,43};    // Avg: 28

        int ex5[] = {2,5,8,13,16,33};       // Avg: 13
        int ex6[] = {8,21,34,37,41,45};     // Avg: 31
        int ex7[] = {3, 8, 24, 27, 28, 49}; // Avg 23

        assertFalse(app.isAverageExceedLimit(ex1, 16, 30));
        assertFalse(app.isAverageExceedLimit(ex2, 16, 30));
        assertFalse(app.isAverageExceedLimit(ex3, 16, 30));
        assertFalse(app.isAverageExceedLimit(ex4, 16, 30));

        assertTrue(app.isAverageExceedLimit(ex5, 16, 30));
        assertTrue(app.isAverageExceedLimit(ex6, 16, 30));

        assertFalse(app.isAverageExceedLimit(ex7, 16, 30));
    }


    @Test
    public void test_isRepeatsExceedLimit() {

        LottoApplication app = new LottoApplication();

        int prev[] = {6,13,21,24,32,47};

        int ex1[] = {6,13,22,24,33,46};
        int ex2[] = {7,13,22,24,32,47};
        int ex3[] = {6,13,21,24,32,47};

        int ex4[] = {7,11,12,15,18,47};
        int ex5[] = {7,11,13,15,18,47};
        int ex6[] = {7,11,13,15,18,49};

        int ex7[] = {8,17,22,27,34,37};     // No duplicates
        int ex8[] = {8,17,22,24,34,37};     // 1 duplicate
        int ex9[] = {8,13,22,24,34,37};     // 2 duplicates

        int ex10[] = {3, 8, 24, 27, 28, 49}; // Avg 23

        assertTrue(app.isRepeatsExceedLimit(prev, ex1, 2));
        assertTrue(app.isRepeatsExceedLimit(prev, ex2, 2));
        assertTrue(app.isRepeatsExceedLimit(prev, ex3, 2));

        assertFalse(app.isRepeatsExceedLimit(prev, ex4, 2));
        assertFalse(app.isRepeatsExceedLimit(prev, ex5, 2));
        assertFalse(app.isRepeatsExceedLimit(prev, ex6, 2));

        assertFalse(app.isRepeatsExceedLimit(prev, ex7, 1));
        assertFalse(app.isRepeatsExceedLimit(prev, ex8, 1));
        assertTrue(app.isRepeatsExceedLimit(prev, ex9, 1));

        assertFalse(app.isRepeatsExceedLimit(prev, ex10, 1));
    }

    @Test
    public void test_isExceedModulus() {

        LottoApplication app = new LottoApplication();

        int ex1[] = {9, 19, 28, 38, 42, 46};
        int ex2[] = {6,16,21,26,32,47};
        int ex3[] = {6,16,21,26,32,46};
        int ex4[] = {3, 8, 24, 27, 28, 49};

        assertTrue(app.isExceedModulus(ex1, 10,2));
        assertFalse(app.isExceedModulus(ex2, 10,3));
        assertTrue(app.isExceedModulus(ex3, 10,3));
        assertFalse(app.isExceedModulus(ex4, 10,2));

    }


    @Test
    public void test_isExceedPopularNumbers() {

        LottoApplication app = new LottoApplication();

        int ex1[] = {6,16,31,32,35,47};
        int ex2[] = {6,16,28,31,35,47};
        int ex3[] = {6,16,34,42,45,47};

        int ex4[] = {6,33,36,37,45,47};
        int ex5[] = {32,33,36,37,45,47};
        int ex6[] = {3, 8, 24, 27, 28, 49};

        assertFalse(app.isExceedPopularNumbers(ex1, 31, 2, 4));
        assertFalse(app.isExceedPopularNumbers(ex2, 31, 2, 4));
        assertFalse(app.isExceedPopularNumbers(ex3, 31, 2, 4));

        assertTrue(app.isExceedPopularNumbers(ex4, 31, 2, 4));
        assertTrue(app.isExceedPopularNumbers(ex5, 31, 2, 4));

        assertFalse(app.isExceedPopularNumbers(ex6, 31, 1, 3));
    }

}