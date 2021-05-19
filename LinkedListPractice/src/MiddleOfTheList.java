import java.util.List;

/**
 * Leetcode 876
 */
public class MiddleOfTheList {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(6);
        ListNode a3 = new ListNode(2);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        ListNode res = findMiddle2(a);
        System.out.println(res.toString());

    }

    public static ListNode findMiddle1(ListNode head){
        int count = 0;
        ListNode cur = head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        int pointer = 0;
        cur = head;
        while(pointer < count/2){
            pointer++;
            cur = cur.next;
        }
        return cur;
    }

    public static ListNode findMiddle2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
