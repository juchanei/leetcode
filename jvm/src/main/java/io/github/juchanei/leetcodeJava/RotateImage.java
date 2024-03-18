package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int a = 0; a < n/2; a++) {
            for (int b = a; b < n - 1 - a; b++) {
                int c = n - 1 - a;
                int d = n - 1 - b;

                int one   = matrix[a][b];
                int two   = matrix[b][c];
                int three = matrix[c][d];
                int four  = matrix[d][a];

                matrix[a][b] = four;
                matrix[b][c] = one;
                matrix[c][d] = two;
                matrix[d][a] = three;
            }
        }
    }

    @Nested
    class UnitTest {
        private final RotateImage sut = new RotateImage();

        @Test
        public void example1() {
            int[][] expected = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
            };
            int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            };
            sut.rotate(matrix);

            assertArrayEquals(expected, matrix);
        }

        @Test
        public void example2() {
            int[][] expected =  {
                {15,13,2, 5 },
                {14,3, 4, 1 },
                {12,6, 8, 9 },
                {16,7, 10,11}
            };
            int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13,3, 6, 7 },
                {15,14,12,16}
            };
            sut.rotate(matrix);

            assertArrayEquals(expected, matrix);
        }

        @Test
        public void example3() {
            int[][] expected =  {{1}};
            int[][] matrix = {{1}};
            sut.rotate(matrix);

            assertArrayEquals(expected, matrix);
        }

        @Test
        public void test1() {
            int[][] expected =  {
                {21,15,13,2, 5 },
                {22,14,3, 4, 1 },
                {23,12,6, 8, 9 },
                {24,16,7, 10,11},
                {25,10,3, 2, 1 },
            };
            int[][] matrix = {
                {5, 1, 9, 11, 1},
                {2, 4, 8, 10, 2},
                {13,3, 6, 7,  3},
                {15,14,12,16,10},
                {21,22,23,24,25}
            };
            sut.rotate(matrix);

            assertArrayEquals(expected, matrix);
        }
    }
}
