package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? = head?.reversed()

    @Test
    fun example1() {
        val l = listOf(1, 2)

        val actual = reverseList(l.toListNode())

        then(actual.toList()).isEqualTo(l.reversed())
    }

    @Test
    fun example2() {
        val l = emptyList<Int>()

        val actual = reverseList(l.toListNode())

        then(actual.toList()).isEqualTo(l.reversed())
    }

    @Test
    fun example3() {
        val l = listOf(1)

        val actual = reverseList(l.toListNode())

        then(actual.toList()).isEqualTo(l.reversed())
    }

    @Test
    fun example4() {
        val l = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

        val actual = reverseList(l.toListNode())

        then(actual.toList()).isEqualTo(l.reversed())
    }
}
