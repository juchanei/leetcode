package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] productsFromLeft = new int[nums.length];
        productsFromLeft[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productsFromLeft[i] = productsFromLeft[i - 1] * nums[i - 1];
        }

        int[] productsFromRight = new int[nums.length];
        productsFromRight[nums.length - 1] = 1;
        for (int i = nums.length - 2; 0 <= i; i--) {
            productsFromRight[i] = productsFromRight[i + 1] * nums[i + 1];
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = productsFromLeft[i] * productsFromRight[i];
        }

        return ret;
    }

    public static class UnitTest {
        private ProductOfArrayExceptSelf poes = new ProductOfArrayExceptSelf();

        @Test()
        public void example1() {
            int[] input = { 1, 2, 3, 4 };
            int[] output = { 24, 12, 8, 6 };
            Assert.assertArrayEquals(output, poes.productExceptSelf(input));
        }
    }
}
