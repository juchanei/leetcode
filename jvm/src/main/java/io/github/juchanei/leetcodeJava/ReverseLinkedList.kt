package io.github.juchanei.leetcodeJava

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
class ReverseLinkedList {
    data class ListNode(val `val`: Int, val next: ListNode?)

    fun reverseList(head: ListNode?): ListNode? =
        reverseList(head = head, acc = null)

    private tailrec fun reverseList(head: ListNode?, acc: ListNode?): ListNode? =
        if (head == null) {
            acc
        } else {
            reverseList(
                head = head.next,
                acc = ListNode(head.`val`, acc)
            )
        }

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

    private fun List<Int>.toListNode(): ListNode? {
        if (isEmpty()) return null
        return ListNode(first(), drop(1).toListNode())
    }

    private fun ListNode?.toList(): List<Int> {
        val result = mutableListOf<Int>()

        var node: ListNode? = this
        while (true) {
            if (node == null) break
            result.add(node.`val`)
            node = node.next
        }

        return result
    }
}
