package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SetMatrixZeroes {
    private int[][] matrix;

    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;

        setZeroes(0, 0, matrix[0][0] == 0);
    }

    private void setZeroes(int x, int y, boolean isZero) {
        boolean found = false;
        for (int i = y; i < matrix.length && !found; i++) {
            for (int j = i == y ? x + 1 : 0; j < matrix[i].length && !found; j++) {
                if (matrix[i][j] == 0) {
                    setZeroes(j, i, true);

                    found = true;
                }
            }
        }

        if (!isZero) return;

        Arrays.fill(matrix[y], 0);

        for (int i = 0; i < matrix.length; i++)
            matrix[i][x] = 0;
    }

    @Nested
    class UnitTest {
        private final SetMatrixZeroes sut = new SetMatrixZeroes();

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
            sut.setZeroes(input);

            assertArrayEquals(output, input);
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
            sut.setZeroes(input);

            assertArrayEquals(output, input);
        }

        @Test
        public void test1() {
            int[][] input = {
                {0},
            };
            int[][] output = {
                {0},
            };
            sut.setZeroes(input);

            assertArrayEquals(output, input);
        }

        @Test
        public void test2() {
            int[][] input = {
                {1, 0},
            };
            int[][] output = {
                {0, 0},
            };
            sut.setZeroes(input);

            assertArrayEquals(output, input);
        }
    }
}
