package io.github.juchanei.leetcodeKotlin

data class ListNode(val `val`: Int, var next: ListNode?) {
    override fun equals(other: Any?): Boolean = equals(this, other as? ListNode)
}

fun List<Int>.toListNode(): ListNode? {
    val head = ListNode(0, null)

    var temp = head
    forEach {
        val next = ListNode(it, null)
        temp.next = next
        temp = next
    }

    return head.next
}

fun ListNode?.toList(): List<Int> {
    val result = mutableListOf<Int>()

    var node: ListNode? = this
    while (true) {
        if (node == null) break
        result.add(node.`val`)
        node = node.next
    }

    return result
}

fun ListNode.reversed(): ListNode = reverse(this)

tailrec fun reverse(head: ListNode, acc: ListNode? = null): ListNode =
    if (head.next == null) {
        ListNode(head.`val`, acc)
    } else {
        reverse(head.next as ListNode, ListNode(head.`val`, acc))
    }

tailrec fun equals(a: ListNode?, b: ListNode?, acc: Boolean = true): Boolean {
    if (a == null && b == null) return acc
    if (a == null) return false
    if (b == null) return false
    return equals(a.next, b.next, acc && a.`val` == b.`val`)
}
