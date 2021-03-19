package practice;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//// * Definition for a binary tree node.
// class TreeNode {
//     int val;
//    TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class Codec {

    static StringBuilder sb = new StringBuilder();
    static TreeNode root;

    public static void main(String[] args) {
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(1);
        TreeNode tn5 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(5);
        root = new TreeNode(4);
        root.left = tn2;
        root.right = tn4;

        tn2.left = tn3;
        tn2.right = tn5;

        serialize(root);

    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            sb.append("null").append(",");
        }else{
            sb.append(root.val).append(",");
            serialize(root.left);
            serialize(root.right);
        }

        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserializeIntoTree(nodes);
    }

    private static TreeNode deserializeIntoTree(Deque<String> nodes) {
        String value = nodes.remove();
        if (value.equals("null")){
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(value));
            node.left = deserializeIntoTree(nodes);
            node.right = deserializeIntoTree(nodes);
            return node;
        }
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));