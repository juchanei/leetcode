package io.github.juchanei.leetcodeKotlin

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
class PalindromeLinkedList {
    // TODO: do it in O(n) time and O(1) space
    fun isPalindrome(head: ListNode?): Boolean =
        if (head == null) true else head == head.reversed()

    @Test
    fun example1() {
        val head = listOf(1, 2, 2, 1).toListNode()

        then(isPalindrome(head)).isTrue
    }

    @Test
    fun example2() {
        val head = listOf(1, 2).toListNode()

        then(isPalindrome(head)).isFalse
    }

    @Test
    fun example3() {
        val head = listOf(1, 2, 1).toListNode()

        then(isPalindrome(head)).isTrue
    }

    @Test
    fun example4() {
        val head = listOf(1, 2, 2).toListNode()

        then(isPalindrome(head)).isFalse
    }

    @Test
    fun example5() {
        val head = generateSequence(0) { it }
            .take(100000)
            .toList()
            .toListNode()

        then(isPalindrome(head)).isTrue
    }
}
