package leetCode.easy;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */
public class ReverseLinkedList {

    static ListNode head;
    public static ListNode reverseList(ListNode head) {
        ListNode next;
        ListNode current = head;
        ListNode previous = null;
        if (current == null || current.next == null)
            return current;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;

    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new ListNode(85);
        list.head.next = new ListNode(15);
        list.head.next.next = new ListNode(4);
        list.head.next.next.next = new ListNode(20);
        ListNode returnNode = reverseList(head);
        printList(returnNode);
    }

}

