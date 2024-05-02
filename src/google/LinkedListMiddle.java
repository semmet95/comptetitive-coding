public class LinkedListMiddle {

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

    public ListNode middleNode(ListNode head) {
        ListNode slider = head;
        ListNode doubleSlider = head;

        while(doubleSlider != null && doubleSlider.next != null) {
            slider = slider.next;
            doubleSlider = doubleSlider.next.next;
        }

        return slider;
    }
}
