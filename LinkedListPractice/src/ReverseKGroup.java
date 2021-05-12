/**
 * Leetcode problem 25
 */
public class ReverseKGroup {
    public static void main(String[] args){

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        while(head != null) {
            ListNode tail = pre;
            for(int i = 0; i<k; i++){
                tail = tail.next;
                if(tail == null){
                    return preHead.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = reverseSubList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return preHead;
    }

    public static ListNode[] reverseSubList(ListNode head, ListNode tail){
        ListNode prev = null;
        ListNode p = head;
        while(prev != tail) {
            ListNode  nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
