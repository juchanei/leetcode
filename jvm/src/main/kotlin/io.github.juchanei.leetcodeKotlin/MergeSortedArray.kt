package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/problems/merge-sorted-array/
class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        tailrec fun merge(i: Int, j: Int, k: Int) {
            when {
                j < 0 -> return
                i < 0 || nums2[j] > nums1[i] -> {
                    nums1[k] = nums2[j]
                    merge(
                        i = i,
                        j = j - 1,
                        k = k - 1
                    )
                }
                else -> {
                    nums1[k] = nums1[i]
                    merge(
                        i = i - 1,
                        j = j,
                        k = k - 1
                    )
                }
            }
        }

        merge(
            i = m - 1,
            j = n - 1,
            k = m + n - 1
        )
    }

    @Test
    fun example1() {
        // given
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val nums2 = intArrayOf(2, 5, 6)
        val m = 3
        val n = 3
        val expected = intArrayOf(1, 2, 2, 3, 5, 6)

        // when
        merge(nums1, m, nums2, n)

        // then
        then(nums1).isEqualTo(expected)
    }

    @Test
    fun example2() {
        // given
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf()
        val m = 1
        val n = 0
        val expected = intArrayOf(1)

        // when
        merge(nums1, m, nums2, n)

        // then
        then(nums1).isEqualTo(expected)
    }

    @Test
    fun example3() {
        // given
        val nums1 = intArrayOf(0)
        val nums2 = intArrayOf(1)
        val m = 0
        val n = 1
        val expected = intArrayOf(1)

        // when
        merge(nums1, m, nums2, n)

        // then
        then(nums1).isEqualTo(expected)
    }

    @Test
    fun example4() {
        // given
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val nums2 = intArrayOf(4, 5, 6)
        val m = 3
        val n = 3
        val expected = intArrayOf(1, 2, 3, 4, 5, 6)

        // when
        merge(nums1, m, nums2, n)

        // then
        then(nums1).isEqualTo(expected)
    }
}
