package practice;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDiameterTree {
    int ans;

    public static void main(String[] args) {
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(1);
        TreeNode tn5 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(5);
        TreeNode root = new TreeNode(4);
        root.left = tn2;
        root.right = tn4;

        tn2.left = tn3;
        tn2.right = tn5;


    }
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}

