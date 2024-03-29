package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        int[] R = new int[nums.length];
        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; 0 <= i; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = L[i] * R[i];
        }

        return ret;
    }

    @Nested
    class UnitTest {
        private final ProductOfArrayExceptSelf sut = new ProductOfArrayExceptSelf();

        @Test()
        public void example1() {
            int[] input = { 1, 2, 3, 4 };
            int[] output = { 24, 12, 8, 6 };
            assertArrayEquals(output, sut.productExceptSelf(input));
        }
    }
}
