package practice;

public class RevrseList {
    public static void main(String[] args) {
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode root = new ListNode(1, l2);

//        new reorderList().orderList(l);

//        if (root == null || root.next == null)
//            return root;

        ListNode a = root;
        ListNode b = root.next;
        ListNode c= root.next.next;

        root.next = null;
        while (b != null) {
            b.next = a;
            a = b;
            b = c;
            c = c == null ? null : c.next;
        }

        System.out.println(a.val + "  " +  a.next.val + " " + a.next.next.val);

//        return a;
    }

}

class ListNode {
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

