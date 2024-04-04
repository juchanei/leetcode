package io.github.juchanei.leetcodeJava;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    private int[] nums = null;
    private Memo memo = null;

    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.memo = new Memo(nums.length + 1, nums.length + 1);

        return recursion(null, 0);
    }

    // NOTE: pivot 이 아직 선택되지 않은 경우 pivotIndex 를 null 로 한다.
    private int recursion(Integer pivotIndex, int index) {
        if (this.memo.contains(pivotIndex, index)) {
            return this.memo.get(pivotIndex, index);
        }

        if (this.nums.length == index) return 0;

        int result;
        if (pivotIndex == null || this.nums[pivotIndex] < this.nums[index]) {
            result = Math.max(
                recursion(index, index + 1) + 1,
                recursion(pivotIndex, index + 1)
            );
        } else {
            result = recursion(pivotIndex, index + 1);
        }

        return this.memo.setAndGet(pivotIndex, index, result);
    }

    static class Memo {
        private final int EMPTY = -1;
        private final int[][] memo;

        Memo(int size1, int size2) {
            this.memo = new int[size1][size2];
            for (int[] l : this.memo) Arrays.fill(l, EMPTY);
        }

        boolean contains(Integer i, int j) {
            if (i == null) return false;
            return this.memo[i][j] != EMPTY;
        }

        int get(Integer i, int j) {
            return this.memo[i][j];
        }

        int setAndGet(Integer i, int j, int value) {
            if (i == null) return value;
            return this.memo[i][j] = value;
        }
    }

    @Nested
    class UnitTest {
        @Test
        public void example1() {
            // given
            int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

            // when
            int result = lengthOfLIS(nums);

            // then
            assertEquals(4, result);
        }

        @Test
        public void example2() {
            // given
            int[] nums = {0, 1, 0, 3, 2, 3};

            // when
            int result = lengthOfLIS(nums);

            // then
            assertEquals(4, result);
        }

        @Test
        public void example3() {
            // given
            int[] nums = {7, 7, 7, 7, 7, 7, 7};

            // when
            int result = lengthOfLIS(nums);

            // then
            assertEquals(1, result);
        }
    }
}
