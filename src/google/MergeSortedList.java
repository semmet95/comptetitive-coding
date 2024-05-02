public class MergeSortedList {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode tempPtr = newHead;
        
        while(list1!= null && list2!= null) {
            if(list1.val < list2.val) {
                tempPtr.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tempPtr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tempPtr = tempPtr.next;
        }

        if(list1 == null) {
            tempPtr.next = list2;
        } else {
            tempPtr.next = list1;
        }
        
        return newHead.next;
    }
}
