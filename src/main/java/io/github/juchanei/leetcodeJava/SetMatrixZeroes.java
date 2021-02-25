package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZeroes {
    private int[][] matrix;

    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;

        setZeroes(0, 0, matrix[0][0] == 0);
    }

    private void setZeroes(int x, int y, boolean isZero) {
        if (x + 1 < matrix[y].length) setZeroes(x + 1, y, matrix[y][x + 1] == 0);
        else if (y + 1 < matrix.length) setZeroes(0, y + 1, matrix[y + 1][0] == 0);

        if (!isZero) return;

        for (int i = 0; i < matrix[y].length; i++)
            matrix[y][i] = 0;

        for (int i = 0; i < matrix.length; i++)
            matrix[i][x] = 0;
    }

    public static class UnitTest {
        private SetMatrixZeroes smz = new SetMatrixZeroes();

        @Test
        public void example1() {
            int[][] input = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
            };
            int[][] output = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1},
            };
            smz.setZeroes(input);

            Assert.assertArrayEquals(output, input);
        }

        @Test
        public void example2() {
            int[][] input = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5},
            };
            int[][] output = {
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0},
            };
            smz.setZeroes(input);

            Assert.assertArrayEquals(output, input);
        }

        @Test
        public void test1() {
            int[][] input = {
                {0},
            };
            int[][] output = {
                {0},
            };
            smz.setZeroes(input);

            Assert.assertArrayEquals(output, input);
        }

        @Test
        public void test2() {
            int[][] input = {
                {1, 0},
            };
            int[][] output = {
                {0, 0},
            };
            smz.setZeroes(input);

            Assert.assertArrayEquals(output, input);
        }
    }
}
