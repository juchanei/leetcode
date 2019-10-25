/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}

var addTwoNumbers = function(l1, l2) {

    const END = new ListNode(null)
    
    let out = new ListNode(null)
    let node1 = l1
    let node2 = l2
    let node3 = out

    while (node1 || node2) {
        node1 = node1 || END
        node2 = node2 || END

        const sum = node1.val + node2.val + node3.val
        const carry = Math.floor(sum / 10)

        node3.val = sum%10

        if (carry || node1.next || node2.next)
            node3.next = new ListNode(carry)

        console.log(node3)

        node1 = node1.next
        node2 = node2.next
        node3 = node3.next
    }

    return out
};
