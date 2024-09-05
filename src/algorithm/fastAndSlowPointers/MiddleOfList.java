package algorithm.fastAndSlowPointers;

public class MiddleOfList {

    static ListNode head;
    public static ListNode middleOfList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfList list = new MiddleOfList();
        list.head = new ListNode(3);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(0);
        list.head.next.next.next = new ListNode(-4);
        list.head.next.next.next.next = new ListNode(1);
        list.head.next.next.next.next.next = new ListNode(11);
        System.out.println(middleOfList(head).val);
    }
}
