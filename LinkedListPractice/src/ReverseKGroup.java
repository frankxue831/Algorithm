/**
 * Leetcode problem 25
 */
public class ReverseKGroup {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(2);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = b;

        b.next = b1;
        b1.next = b2;
        b2.next = b3;

        System.out.println(reverseKGroup(a,3).toString());

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
