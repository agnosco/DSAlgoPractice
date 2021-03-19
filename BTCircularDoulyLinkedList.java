package practice;

import sun.reflect.generics.tree.Tree;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

public class BTCircularDoulyLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode l1 = new TreeNode(12);
        root.left = l1;
        TreeNode r1 = new TreeNode(15);
        root.right = r1;
        TreeNode l2 = new TreeNode(25);
        l1.left = l2;
        TreeNode r2 = new TreeNode(36);
        r1.right = r2;

        Hashtable<Integer, Integer> map = new Hashtable<>();
        map.put(1,1);
    }
}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//
//    }
//
//}