public class LinkedListReversed {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode newHead = new ListNode(head.val);

        for(ListNode node = head.next; node != null; node = node.next) {
            ListNode temp = new ListNode(node.val);
            temp.next = newHead;
            newHead = temp;
        }

        StringBuffer sb = new StringBuffer();

        return newHead;
    }
}
