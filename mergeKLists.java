//package practice;
//
//import java.util.*;
//
//public class mergeKLists {
//
//    public static void main(String[] args) {
//
//        ListNode listNode = new ListNode(0);
//        listNode.val = 3;
//        ListNode listNode2 = new ListNode(0);
//        listNode2.val = 4;
//        listNode.next = listNode2;
//        ListNode listNode3 = new ListNode(1);
//        listNode3.val = 2;
//        ListNode listNode4 = new ListNode(1);
//        listNode4.val = 6;
//        listNode3.next = listNode4;
//        ListNode listNode5 = new ListNode(1);
//        listNode5.val = 7;
//        listNode4.next = listNode5;
//
//        ListNode[] listNodes = new ListNode[]{listNode, listNode3};
////        [[1,4,5],[1,3,4],[2,6]]
//        mergeKListsArraySort(listNodes);
//
//
//    }
//
//    private static ListNode mergeKListsArraySort(ListNode[] listNodes) {
//
//        List<Integer> list = new ArrayList<>();
//        for (ListNode ln:
//             listNodes) {
//            while (ln != null) {
//                list.add(ln.val);
//                ln = ln.next;
//            }
//
//        }
//
//        Collections.sort(list);
//
//        ListNode head = new ListNode(0);
//        ListNode temp = head;
//        for (Integer i:
//             list) {
//            ListNode ln = new ListNode(i);
//            temp.next = ln;
//            temp = temp.next;
//        }
//
//        temp.next = null;
//        return head.next;
//
//
//
//    }
////
////
////    public static ListNode mergeKLists(ListNode[] lists) {
////
////        Comparator<ListNode> comparator = new Comparator<ListNode>() {
////            @Override
////            public int compare(ListNode o1, ListNode o2) {
////                return o1.val - o2.val;
////            }
////        };
////
////        Queue<ListNode> queue = new PriorityQueue<>(comparator);
////
////        for (ListNode ln: lists) {
////            if(ln != null){
////                queue.add(ln);
////            }
////        }
////
////        ListNode headNode = new ListNode(0);
////        ListNode rootNode  = headNode;
////
////+        while (!queue.isEmpty()){
////            rootNode.next = queue.poll();
////            rootNode = rootNode.next;
////            ListNode nextNode = rootNode.next;
////            if(nextNode != null){
////                queue.add(nextNode);
////            }
////        }
////
////        return headNode;
//    }
////    public ListNode mergeKLists(ListNode[] lists) {
////        ListNode node = lists[0];
////        for(int i = 1; i < lists.length -1; i++){
////            node = mergeTwoLists(node, lists[i]);
////        }
////
////        return node;
////    }
////
////    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
////        ListNode newNode = new ListNode(0);
////        ListNode tail = newNode;
////
////        while(true){
////            if(l1 == null){
////                tail.next = l2;
////                break;
////            }
////            if(l2 == null){
////                tail.next = l1;
////                break;
////            }
////            if(l1.val < l2.val){
////                tail.next = l1;
////                l1 = l1.next;
////            }else{
////                tail.next = l2;
////
////                l2 = l2.next;
////            }
////            tail = tail.next;
////        }
////
////        return newNode.next;
////    }
//}
////
//// class ListNode {
////      int val;
////      ListNode next;
////      ListNode() {}
////      ListNode(int val) { this.val = val; }
////      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
////  }
