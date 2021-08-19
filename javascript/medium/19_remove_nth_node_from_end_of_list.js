/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */

var removeNthFromEnd = function(head, n) {

    const _removeNthFromEnd = current => {
        if (current === null) return { current: null, position: 0 }

        const nextNode = _removeNthFromEnd(current.next)
        const position = nextNode.position + 1
        current.next = nextNode.current

        if (position === n) return { current: current.next, position }

        return { current, position }
    }

    return _removeNthFromEnd(head).current
};