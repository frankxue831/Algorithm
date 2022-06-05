import org.w3c.dom.NodeList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int num){
        val = num;
        next = null;
    }

    public ListNode(int num, ListNode node){
        val = num;
        next = node;
    }

    public int getVal() {
        return val;
    }


    public void setVal(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        return "ListNode:" +
                "val=" + val +
                "--->" + next;
    }

    public String toString(String s) {
        return "ListNode:" +
                "val=" + val +
                "--->" + next;
    }

    public void addAtHead(int val) throws CloneNotSupportedException {
        ListNode before = (ListNode) this.clone();
        ListNode temp = new ListNode(val, before);
        this.next = temp;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head == null){
            return false;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;

    }

    public static void main(String[]  args) throws CloneNotSupportedException {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);


        b.next = a;
        b.addAtHead(3);
        System.out.println(b.toString());
    }
}
