package practice;

import java.util.*;

public class LevelOrderBST {
    public static void main(String[] args) {
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(1);
        TreeNode tn5 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(5);
        TreeNode root;
        root = new TreeNode(4);
        root.left = tn2;
        root.right = tn4;

        tn2.left = tn3;
        tn2.right = tn5;
        new LevelOrderBST().levelOrder(root);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> valQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        valQueue.add(root);
//        valQueue.add(root.right);
        levelQueue.add(0);
//        levelQueue.add(1);

        finalList.add(new ArrayList<>(root.val));
        return pushToLevel(root, 1, levelQueue, valQueue);
    }

    public List<List<Integer>> pushToLevel(TreeNode root, int level, Queue<Integer> levelQueue, Queue<TreeNode> valQueue){


        List<Integer> subList = new ArrayList<>();

        List<List<Integer>> finalList = new ArrayList<>();

        while (!levelQueue.isEmpty()){
            TreeNode node = valQueue.peek();
            if(level < levelQueue.peek()){
                finalList.add(subList);
                subList = new ArrayList<>();
                level = levelQueue.peek();
            }
            if(node != null){
                subList.add(node.val);
                valQueue.add(node.left);
                levelQueue.add(level + 1);
                valQueue.add(node.right);
                levelQueue.add(level + 1);
            }

            valQueue.poll();
            levelQueue.poll();
        }

        return finalList;

    }
}
