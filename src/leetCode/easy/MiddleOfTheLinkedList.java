package leetCode.easy;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 */
public class MiddleOfTheLinkedList {

    static ListNode head;

    public ListNode middleNode(ListNode head) {
//        ListNode temp = head;
//        int i = 0;
//        while (temp != null) {
//            temp = temp.next;
//            i++;
//        }
//
//        int mid = (i / 2) + 1;
//
//        for (int j = 1;j<mid;j++) {
//            head = head.next;
//        }
//
//        return head;

        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList list = new MiddleOfTheLinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);

    }
}
