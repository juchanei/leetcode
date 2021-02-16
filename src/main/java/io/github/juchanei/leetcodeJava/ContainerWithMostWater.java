package io.github.juchanei.leetcodeJava;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWater {

    private int[] height;

    public int maxArea(int[] height) {
        this.height = height;

        int left = 0;
        int right = height.length - 1;
        int max = calcWater(left, right);

        while (true) {
            if (height[left] < height[right])
                left = findNextLeftPosition(left);
            else
                right = findNextRightPosition(right);

            if (right <= left) break;
            max = Math.max(max, calcWater(left, right));
        }

        return max;
    }

    private int calcWater(int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }

    private int findNextLeftPosition(int left) {
        int prevHeight = height[left];
        while (left < height.length - 1 && height[left] <= prevHeight) left++;
        return left;
    }

    private int findNextRightPosition(int right) {
        int prevHeight = height[right];
        while (0 < right && height[right] <= prevHeight) right--;
        return right;
    }

    public static class UnitTest {
        private ContainerWithMostWater cw = new ContainerWithMostWater();

        @Test
        public void example1() {
            int[] input = {1,8,6,2,5,4,8,3,7};
            int expected = 49;
            int actual = cw.maxArea(input);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void example2() {
            int[] input = {4,3,2,1,4};
            int expected = 16;
            int actual = cw.maxArea(input);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void example3() {
            int[] input = {1,2,1};
            int expected = 2;
            int actual = cw.maxArea(input);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void test1() {
            int[] input = {1,8,6,2,5,4,8,3,7,9,8,7,6,5,4,3,2,1};
            int expected = 72;
            int actual = cw.maxArea(input);
            Assert.assertEquals(expected, actual);
        }
    }
}
