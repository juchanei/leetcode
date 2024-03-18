package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheDuplicateNumber {
    private int[] nums;

    public int findDuplicate(int[] nums) {
        this.nums = nums;

        return floyd(nums[0], nums[0]);
    }

    // Floyd cycle detection algorithm.
    private int floyd(int tortoise, int hare) {
        do {
            tortoise = next(tortoise);
            hare = next(next(hare));
        } while (tortoise != hare);

        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = next(tortoise);
            hare = next(hare);
        }

        return tortoise;
    }

    private int next(int current) {
        return nums[current];
    }

    @Nested
    class UnitTest {
        private final FindTheDuplicateNumber sut = new FindTheDuplicateNumber();

        @Test
        public void example1() {
            int[] input = { 1,3,4,2,2 };
            int output = 2;
            assertEquals(output, sut.findDuplicate(input));
        }

        @Test
        public void example2() {
            int[] input = { 3,1,3,4,2 };
            int output = 3;
            assertEquals(output, sut.findDuplicate(input));
        }

        @Test
        public void example3() {
            int[] input = { 1,1 };
            int output = 1;
            assertEquals(output, sut.findDuplicate(input));
        }

        @Test
        public void example4() {
            int[] input = { 1,1,2 };
            int output = 1;
            assertEquals(output, sut.findDuplicate(input));
        }

        @Test
        public void test1() {
            int[] input = new int[30001];
            int output = 1;
            for (int i = 0; i < 30000; i++) input[i] = i + 1;
            input[30000] = output;

            assertEquals(output, sut.findDuplicate(input));
        }

        @Test
        public void test2() {
            int[] input = { 2,2,2 };
            int output = 2;
            assertEquals(output, sut.findDuplicate(input));
        }
    }
}
