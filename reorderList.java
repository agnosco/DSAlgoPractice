package practice;

import java.util.ArrayList;

public class reorderList {

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l = new ListNode(1, l2);

        new reorderList().orderList(l);
    }

    public void orderList(ListNode head) {
        if (head == null || head.next == null) return;

        ArrayList<ListNode> arrayList = new ArrayList<>();
        ListNode root = head.next;
        int i = 0;
        while (root != null){
            arrayList.add(i, root);
            root = root.next;
            i++;
        }
        ListNode root1 = head;
        while (root1 != null && i > 0){
            ListNode temp = root1.next;
            root1.next = arrayList.get(i -1);
            root1.next.next = i == 0? null : temp;
            root1 = temp != null ? temp : null;
            i--;
        }
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode n = reverse(slow.next);
//        slow.next = null;
//
//        ListNode m = head;
//
//        while (m != null && n != null) {
//            ListNode tempM = m.next;
//            ListNode tempN = n.next;
//
//            m.next = n;
//            n.next = tempM;
//            m = tempM;
//            n = tempN;
//        }
    }

    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null) return root;

        ListNode a = root;
        ListNode b = root.next;

        root.next = null;
        while (b != null) {
            ListNode temp = b.next;
            b.next = a;
            a = b;
            b = temp;
        }
        return a;
    }

}

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
