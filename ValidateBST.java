//package practice;
//
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//public class ValidateBST {
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        TreeNode tn2 = new TreeNode(4);
//        TreeNode tn3 = new TreeNode(6);
//        TreeNode tn5 = new TreeNode(3);
//        TreeNode tn4 = new TreeNode(7);
//        root.left = tn2;
//        root.right = tn3;
//
//        tn3.left = tn4;
//        tn3.right = tn5;
//        System.out.println(isValidBST(root));
//
//    }
//
//    private static boolean isValidBST(TreeNode root) {
//
//
//        while(root != null){
//
//            if(root.left != null && root.left.val >= root.val){
//                return false;
//            }
//
//            if (root.right != null && root.right.val <= root.val){
//                return false;
//            }
//
//            return isValidBST(root.left) &&
//                    isValidBST(root.right);
//
//        }
//
//        return true;
//    }
//}
//
//
//    public boolean isValidBST(TreeNode root) {
//        if((root.left == null && root.right == null)){
//            return true;
//        }
//        long max=Long.MAX_VALUE;
//        long min=Long.MIN_VALUE;
//
//        return isValid(root,max,min);
//    }
//
//    public boolean isValid(TreeNode root, long max, long min){
//        if(root == null){
//            return true;
//        }
//
//
//
//        if((root.val < max && root.val > min)){
//            return isValid(root.left,root.val,min) && isValid(root.right,max,root.val);
//        }
//        return false;
//    }
//}
//
