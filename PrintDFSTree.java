package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PrintDFSTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(printBinaryTree(root));
        return finalList;
    }

    public List<Integer> printBinaryTree(TreeNode root){
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        List<Integer> listOfNodes =   new ArrayList<>();
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.peek();
            if(node!= null){
                listOfNodes.add(node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
            }
            nodeQueue.poll();
        }

        return listOfNodes;

    }
}
