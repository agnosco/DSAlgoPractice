package practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;

//Definition for a binary tree node.
//  class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

class PrintBFSTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        finalList.add(printBinaryTree(root));
        return finalList;
    }

    public List<Integer> printBinaryTree(TreeNode root){
        Stack<TreeNode> stackOfNodes = new Stack<>();
        stackOfNodes.push(root);
        List<Integer> listOfNodes =   new ArrayList<>();
        while(!stackOfNodes.isEmpty()){
            TreeNode node = stackOfNodes.pop();
            if(node!= null){
                listOfNodes.add(node.val);
                stackOfNodes.push(node.left);
                stackOfNodes.push(node.right);
            }
        }

        return listOfNodes;

    }
}