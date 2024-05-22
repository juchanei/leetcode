package io.github.juchanei.leetcodeKotlin

data class ListNode(val `val`: Int, var next: ListNode?)

fun List<Int>.toListNode(): ListNode? =
    if (isEmpty()) null else ListNode(first(), drop(1).toListNode())

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
