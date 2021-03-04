package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Floyd cycle detection algorithm.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return tortoise;
    }

    public static class UnitTest {
        private FindTheDuplicateNumber dn = new FindTheDuplicateNumber();

        @Test
        public void example1() {
            int[] input = { 1,3,4,2,2 };
            int output = 2;
            Assert.assertEquals(output, dn.findDuplicate(input));
        }

        @Test
        public void example2() {
            int[] input = { 3,1,3,4,2 };
            int output = 3;
            Assert.assertEquals(output, dn.findDuplicate(input));
        }

        @Test
        public void example3() {
            int[] input = { 1,1 };
            int output = 1;
            Assert.assertEquals(output, dn.findDuplicate(input));
        }

        @Test
        public void example4() {
            int[] input = { 1,1,2 };
            int output = 1;
            Assert.assertEquals(output, dn.findDuplicate(input));
        }

        @Test
        public void test1() {
            int[] input = new int[30001];
            int output = 1;
            for (int i = 0; i < 30000; i++) input[i] = i + 1;
            input[30000] = output;

            Assert.assertEquals(output, dn.findDuplicate(input));
        }

        @Test
        public void test2() {
            int[] input = { 2,2,2 };
            int output = 2;
            Assert.assertEquals(output, dn.findDuplicate(input));
        }
    }
}
