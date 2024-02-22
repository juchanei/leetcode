package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(numbers: IntArray): Int {
        return removeDuplicates(numbers, 0, 0)
    }

    private tailrec fun removeDuplicates(numbers: IntArray, pushIndex: Int, peekIndex: Int): Int = when {
        numbers.size == peekIndex -> pushIndex + 1
        numbers[pushIndex] == numbers[peekIndex] -> removeDuplicates(numbers, pushIndex, peekIndex + 1)
        else -> {
            // TODO: remove mutation
            numbers[pushIndex + 1] = numbers[peekIndex]
            removeDuplicates(numbers, pushIndex + 1, peekIndex + 1)
        }
    }

    @Test
    fun example1() {
        // given
        val numbers = intArrayOf(1, 1, 2)
        val expected = intArrayOf(1, 2)

        // when
        val k = removeDuplicates(numbers)

        // then
        then(numbers.copyOfRange(0, k)).isEqualTo(expected)
    }

    @Test
    fun example2() {
        // given
        val numbers = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val expected = intArrayOf(0, 1, 2, 3, 4)

        // when
        val k = removeDuplicates(numbers)

        // then
        then(numbers.copyOfRange(0, k)).isEqualTo(expected)
    }

    @Test
    fun test1() {
        // given
        val numbers = intArrayOf(0)
        val expected = intArrayOf(0)

        // when
        val k = removeDuplicates(numbers)

        // then
        then(numbers.copyOfRange(0, k)).isEqualTo(expected)
    }

    @Test
    fun test2() {
        // given
        val numbers = IntArray(300000000) { 1 }
        val expected = intArrayOf(1)

        // when
        val k = removeDuplicates(numbers)

        // then
        then(numbers.copyOfRange(0, k)).isEqualTo(expected)
    }
}