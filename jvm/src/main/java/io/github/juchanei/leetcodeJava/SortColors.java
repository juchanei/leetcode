package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                swap(nums, i, left);
                left++;
            }
            else if (2 == nums[i]) {
                swap(nums, i, right);
                i--;
                right--;
            }
            if (right <= i) break;
            if (left == right) break;
        }
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Nested
    class UnitTest {
        private final SortColors sut = new SortColors();

        @Test
        public void example1() {
            int[] input = { 2,0,2,1,1,0 };
            int[] output = { 0,0,1,1,2,2 };

            sut.sortColors(input);
            assertArrayEquals(output, input);
        }

        @Test
        public void example2() {
            int[] input = { 2,0,1 };
            int[] output = { 0,1,2 };

            sut.sortColors(input);
            assertArrayEquals(output, input);
        }

        @Test
        public void example3() {
            int[] input = { 0 };
            int[] output = { 0 };

            sut.sortColors(input);
            assertArrayEquals(output, input);
        }

        @Test
        public void example4() {
            int[] input = { 1 };
            int[] output = { 1 };

            sut.sortColors(input);
            assertArrayEquals(output, input);
        }
    }
}
