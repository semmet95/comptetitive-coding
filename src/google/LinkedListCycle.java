public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slider = head;
        if(slider == null) return false;

        ListNode doubleSlider = head.next;
        if(doubleSlider == null) return false;

        while(slider != doubleSlider) {
            slider = slider.next;
            ListNode temp = doubleSlider.next;

            if(temp == null) return false;
            
            doubleSlider = temp.next;
            if(doubleSlider == null) return false;
        }

        return true;
    }
}
