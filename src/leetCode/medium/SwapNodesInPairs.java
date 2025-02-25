package leetCode.medium;

import leetCode.easy.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * Solved
 * Medium
 * Topics
 * Companies
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode tail = temp;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode nextPair = curr.next.next;

            tail.next = curr.next;
            curr.next.next = curr;
            curr.next = nextPair;

            tail = curr;
            curr = nextPair;
        }

        return temp.next;
    }
}
