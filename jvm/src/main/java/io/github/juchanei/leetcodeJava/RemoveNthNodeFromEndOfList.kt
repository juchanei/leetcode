package io.github.juchanei.leetcodeJava

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
class RemoveNthNodeFromEndOfList {
    class ListNode(var `val`: Int, var next: ListNode? = null)

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null

        val dummy = ListNode(0, head)

        findAndRemoveNode(dummy, n) + 1

        return dummy.next
    }

    private fun findAndRemoveNode(node: ListNode?, n: Int): Int {
        if (node == null) {
            return 0
        } else {
            val indexFromEnd = findAndRemoveNode(node.next, n) + 1

            // 제거할 노드의 직전 노드에서 제거한다
            if (indexFromEnd - 1 == n) {
                removeNextNode(node)
            }

            return indexFromEnd
        }
    }

    private fun removeNextNode(node: ListNode) {
        node.next = node.next!!.next
    }

    @Test
    fun example1() {
        val head = listOf(1, 2, 3, 4, 5).toListNode()
        val n = 2

        val actual = removeNthFromEnd(head, n)

        then(actual.toList()).isEqualTo(listOf(1, 2, 3, 5))
    }

    @Test
    fun example2() {
        val head = listOf(1).toListNode()
        val n = 1

        val actual = removeNthFromEnd(head, n)

        then(actual.toList()).isEqualTo(emptyList<Int>())
    }

    @Test
    fun example3() {
        val head = listOf(1, 2).toListNode()
        val n = 1

        val actual = removeNthFromEnd(head, n)

        then(actual.toList()).isEqualTo(listOf(1))
    }

    @Test
    fun example4() {
        val head = listOf(1, 2).toListNode()
        val n = 2

        val actual = removeNthFromEnd(head, n)

        then(actual.toList()).isEqualTo(listOf(2))
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
