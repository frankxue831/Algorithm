/**
 * LeetCode 19
 */
public class RemoveNthNode {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(7);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println(a.toString());
        ListNode res = removeNthFromEnd(a, 2);
        System.out.println(res.toString());


    }

    public static int getLength(ListNode head){
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }


        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            int length = getLength(head);
                    ListNode cur = dummy;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            ListNode ans = dummy.next;
            return ans;
        }
}
