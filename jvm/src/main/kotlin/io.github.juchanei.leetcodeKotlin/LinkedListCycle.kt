package io.github.juchanei.leetcodeKotlin

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        val visited = emptySet<ListNode>()

        return hasCycle(head, visited)
    }

    private tailrec fun hasCycle(head: ListNode?, visited: Set<ListNode>): Boolean =
        when {
            head == null -> false
            visited.contains(head) -> true
            else -> hasCycle(head.next, visited + head)
        }

    private tailrec fun hasCycle(head: ListNode?, length: Int): Boolean =
        when {
            head == null -> false
            10000 < length -> true
            else -> hasCycle(head.next, length + 1)
        }
}
