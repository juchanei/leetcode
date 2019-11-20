/**
 * https://leetcode.com/problems/sort-list/
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

const swapval = (n1, n2) => {
    const temp = n1.val
    n1.val = n2.val
    n2.val = temp
}

var sortList = function(head) {
    const sort = head => {
        if (!head) return

        let current = head
        while (current) {
            if (current.val < head.val) swapval(current, head)
            current = current.next
        }

        sort(head.next)
    }

    sort(head)
    return head
};
