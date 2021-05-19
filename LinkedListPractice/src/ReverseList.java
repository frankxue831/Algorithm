/**
 * Some operations of link lists
 * 1. reverse the list
 *
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode reverse = null;
        if(head == null || head.next == null){
            return head;
        }
        while(curr != null){
            ListNode temp = head.next;
            curr.next = reverse;
            reverse = curr;
            curr = temp;
        }
        return reverse;
    }
}
