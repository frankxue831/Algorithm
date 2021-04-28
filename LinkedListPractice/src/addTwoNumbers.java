/**
 * adding two numbers by giving numbers as linked lists as following form:
 * 123 -->[3->2->1]
 * 236 -->[6->3->2]
 */
public class addTwoNumbers {
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

        b.next = b1;
        b1.next = b2;
        b2.next = b3;

        //System.out.println(b.toString());
        System.out.println(addTwoNumbers(a,b));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if(head == null) {
                head = tail = new ListNode(sum%10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
