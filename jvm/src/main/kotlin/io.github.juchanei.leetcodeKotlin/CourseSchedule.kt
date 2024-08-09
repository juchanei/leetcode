package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/problems/course-schedule/
class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val memo = mutableMapOf<Int, Boolean>()

        fun validate(course: Int, left: Int): Boolean =
            when {
                left == 0 -> false
                memo.containsKey(course) -> memo[course]!!
                else -> prerequisites
                    .filter { it[0] == course }
                    .all { validate(it[1], left - 1) }
                    .also { memo[course] = it }
            }

        return (0 until numCourses).all { validate(it, numCourses) }
    }

    @Test
    fun example1() {
        // given
        val nc = 2
        val pre = arrayOf(intArrayOf(1, 0))

        // when
        val ret = canFinish(nc, pre)

        // then
        then(ret).isTrue
    }

    @Test
    fun example2() {
        // given
        val nc = 2
        val pre = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))

        // when
        val ret = canFinish(nc, pre)

        // then
        then(ret).isFalse
    }
}
