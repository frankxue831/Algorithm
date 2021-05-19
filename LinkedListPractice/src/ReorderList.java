import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 143
 */
public class ReorderList {
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

        System.out.println(a.toString());
        reorderList1(a);
        System.out.println(a.toString());

    }

    public static void reorderList2(ListNode head){
        if(head == null){
            return;
        }

        ListNode mid = MiddleOfTheList.findMiddle1(head);
        ListNode front = head;
        ListNode back = mid.next;
        //mid.next = null;
        back = ReverseList.reverseList(back);
        mergeList(front, back);


    }

    public static void mergeList(ListNode l1, ListNode l2){
        ListNode temp1;
        ListNode temp2;
        while(l1 != null && l2 != null){
            temp1 = l1.next;
            temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;
            l2.next = l1;
            l2 = temp2;
        }
    }
    public static void reorderList1(ListNode head){
        if(head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size()-1;
        while(i < j){
            list.get(i).next = list.get(j);
            i++;
            if(i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
