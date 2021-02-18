package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class UniquePaths {
    private int m;
    private int n;
    private int[][] cache;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        this.cache = new int[m][n];

        return find(0, 0);
    }

    private int find(int i, int j) {
        if (i == m) return 0;
        if (j == n) return 0;
        if (i == m - 1 && j == n - 1) return 1;

        if (0 < cache[i][j]) return cache[i][j];

        return cache[i][j] = find(i + 1, j) + find(i, j + 1);
    }

    public static class UnitTest {

        private UniquePaths up = new UniquePaths();

        @Test
        public void example1() {
            int expected = 28;
            int actual = up.uniquePaths(3, 7);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void example2() {
            int expected = 3;
            int actual = up.uniquePaths(3, 2);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void example3() {
            int expected = 28;
            int actual = up.uniquePaths(7, 3);

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void example4() {
            int expected = 6;
            int actual = up.uniquePaths(3, 3);

            Assert.assertEquals(expected, actual);
        }
    }

}
