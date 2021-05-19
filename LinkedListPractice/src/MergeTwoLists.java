import com.sun.xml.internal.bind.v2.TODO;

public class MergeTwoLists {
    public static void main(String[] args){

    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        /* TODO: complete the method        */
        return  l1;
    }

    public static ListNode mergeTwoOrderedLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val < l2.val){
            l1.next = mergeTwoOrderedLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoOrderedLists(l1, l2.next);
            return l2;
        }
    }

    // using the iterative method
    public static ListNode mergeTwoOrderedLists2(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 ==null ? l2:l1;
        return prehead.next;
    }
}
