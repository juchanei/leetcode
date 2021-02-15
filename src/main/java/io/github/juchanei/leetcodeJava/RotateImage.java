package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int j = 0; j < n/2; j++) {
            for (int i = j; i < n - 1 - j; i++) {
                int a = j;
                int b = i;
                int c = n - 1 - j;
                int d = n - 1 - i;

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

    public static class UnitTest {
        private RotateImage ri = new RotateImage();

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
            ri.rotate(matrix);

            Assert.assertArrayEquals(expected, matrix);
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
            ri.rotate(matrix);

            Assert.assertArrayEquals(expected, matrix);
        }

        @Test
        public void example3() {
            int[][] expected =  {{1}};
            int[][] matrix = {{1}};
            ri.rotate(matrix);

            Assert.assertArrayEquals(expected, matrix);
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
            ri.rotate(matrix);

            Assert.assertArrayEquals(expected, matrix);
        }
    }
}
