package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
class RotateArray {

    fun rotate(nums: IntArray, k: Int) {
        if (k == 0) return
        if (k % nums.size == 0) return

        rotateLess(nums, k % nums.size)
    }

    private fun rotateLess(nums: IntArray, k: Int) {
        data class Element(val index: Int) {
            val value: Int = nums[index]
        }

        tailrec fun rotateFrom(element: Element, endIndex: Int? = null) {
            if (element.index == endIndex) return

            val rotatedIndex = (element.index + k) % nums.size
            val elementInRotatedIndex = Element(rotatedIndex)
            nums[rotatedIndex] = element.value

            return rotateFrom(
                element = elementInRotatedIndex,
                endIndex = endIndex ?: element.index
            )
        }

        val gcd = findGcd(nums.size, k)

        if (gcd == null) {
            rotateFrom(Element(0))
        } else {
            for (i in 0 until gcd) {
                rotateFrom(Element(i))
            }
        }
    }

    private fun findGcd(big: Int, small: Int): Int? =
        (2..small)
            .reversed()
            .firstOrNull { small % it == 0 && big % it == 0 }

    @Test
    fun example1() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 3

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(5, 6, 7, 1, 2, 3, 4))
    }

    @Test
    fun example2() {
        // given
        val nums = intArrayOf(-1, -100, 3, 99)
        val k = 2

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(3, 99, -1, -100))
    }

    @Test
    fun test0() {
        // given
        val nums = intArrayOf(-1, -100, 3, 99)
        val k = 99999

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(-100, 3, 99, -1))
    }

    @Test
    fun test1() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 1

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(7, 1, 2, 3, 4, 5, 6))
    }

    @Test
    fun test2() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 2

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(6, 7, 1, 2, 3, 4, 5))
    }

    @Test
    fun test3() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 3

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(5, 6, 7, 1, 2, 3, 4))
    }

    @Test
    fun test4() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 4

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(4, 5, 6, 7, 1, 2, 3))
    }

    @Test
    fun test5() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 5

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(3, 4, 5, 6, 7, 1, 2))
    }

    @Test
    fun test6() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 6

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(2, 3, 4, 5, 6, 7, 1))
    }

    @Test
    fun fail2() {
        // given
        val nums = intArrayOf(1, 2, 3, 4, 5, 6)
        val k = 4

        // when
        rotate(nums, k)

        // then
        then(nums).isEqualTo(intArrayOf(3, 4, 5, 6, 1, 2))
    }
}
