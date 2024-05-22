package io.github.juchanei.leetcodeKotlin

class DeleteNodeInALinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteNode(node: ListNode?) {
        val next = node?.next ?: return
        node.`val` = next.`val`
        node.next = next.next
    }
}
