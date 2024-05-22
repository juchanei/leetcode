package io.github.juchanei.leetcodeJava

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
class MergeTwoSortedLists {
    data class ListNode(val `val`: Int, val next: ListNode?)

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? =
        mergeTwoLists(list1, list2, null)?.reversed()

    private tailrec fun mergeTwoLists(list1: ListNode?, list2: ListNode?, acc: ListNode?): ListNode? =
        if (list1 == null && list2 == null) {
            acc
        } else if (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) {
                mergeTwoLists(list1.next, list2, ListNode(list1.`val`, acc))
            } else {
                mergeTwoLists(list1, list2.next, ListNode(list2.`val`, acc))
            }
        } else {
            val value = list1?.`val` ?: list2?.`val` as Int
            mergeTwoLists(list1?.next, list2?.next, ListNode(value, acc))
        }

    private fun ListNode.reversed(): ListNode = reverse(this)

    private tailrec fun reverse(head: ListNode, acc: ListNode? = null): ListNode =
        if (head.next == null) {
            ListNode(head.`val`, acc)
        } else {
            reverse(head.next, ListNode(head.`val`, acc))
        }

    @Test
    fun example1() {
        val l1 = listOf(1, 2, 4)
        val l2 = listOf(1, 3, 4)
        val expected = listOf(1, 1, 2, 3, 4, 4)

        val actual = mergeTwoLists(l1.toListNode(), l2.toListNode())

        then(actual.toList()).isEqualTo(expected)
    }

    @Test
    fun example2() {
        val l1 = emptyList<Int>()
        val l2 = emptyList<Int>()
        val expected = emptyList<Int>()

        val actual = mergeTwoLists(l1.toListNode(), l2.toListNode())

        then(actual.toList()).isEqualTo(expected)
    }

    @Test
    fun example3() {
        val l1 = emptyList<Int>()
        val l2 = listOf(0)
        val expected = listOf(0)

        val actual = mergeTwoLists(l1.toListNode(), l2.toListNode())

        then(actual.toList()).isEqualTo(expected)
    }

    @Test
    fun example4() {
        val l1 = listOf(5)
        val l2 = listOf(1, 2, 4)
        val expected = listOf(1, 2, 4, 5)

        val actual = mergeTwoLists(l1.toListNode(), l2.toListNode())

        then(actual.toList()).isEqualTo(expected)
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
