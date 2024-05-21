package io.github.juchanei.leetcodeKotlin

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

// https://leetcode.com/problems/rotate-image/
class RotateImage {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size

        for (a in 0 until n / 2) {
            for (b in a until n - a - 1) {
                val c = n - a - 1
                val d = n - b - 1

                val one = matrix[a][b]
                val two = matrix[b][c]
                val three = matrix[c][d]
                val four = matrix[d][a]

                matrix[a][b] = four
                matrix[b][c] = one
                matrix[c][d] = two
                matrix[d][a] = three
            }
        }
    }

    @Test
    fun example1() {
        val expected = arrayOf(
            intArrayOf(7, 4, 1),
            intArrayOf(8, 5, 2),
            intArrayOf(9, 6, 3)
        )
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        rotate(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun example2() {
        val expected = arrayOf(
            intArrayOf(15, 13, 2, 5),
            intArrayOf(14, 3, 4, 1),
            intArrayOf(12, 6, 8, 9),
            intArrayOf(16, 7, 10, 11)
        )
        val matrix = arrayOf(
            intArrayOf(5, 1, 9, 11),
            intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7),
            intArrayOf(15, 14, 12, 16)
        )
        rotate(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun example3() {
        val expected = arrayOf(intArrayOf(1))
        val matrix = arrayOf(intArrayOf(1))
        rotate(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun test1() {
        val expected = arrayOf(
            intArrayOf(21, 15, 13, 2, 5),
            intArrayOf(22, 14, 3, 4, 1),
            intArrayOf(23, 12, 6, 8, 9),
            intArrayOf(24, 16, 7, 10, 11),
            intArrayOf(25, 10, 3, 2, 1),
        )
        val matrix = arrayOf(
            intArrayOf(5, 1, 9, 11, 1),
            intArrayOf(2, 4, 8, 10, 2),
            intArrayOf(13, 3, 6, 7, 3),
            intArrayOf(15, 14, 12, 16, 10),
            intArrayOf(21, 22, 23, 24, 25)
        )
        rotate(matrix)

        assertArrayEquals(expected, matrix)
    }
}
