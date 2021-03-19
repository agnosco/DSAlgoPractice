package practice;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> myList = new ArrayList<>();
    int indexCurrent = 0;

    public BSTIterator(TreeNode root) {
        traverseInOrder(root);
    }

    public int next() {
        return myList.get(indexCurrent++);
    }

    public boolean hasNext() {
        return indexCurrent < myList.size();
    }

    private void traverseInOrder(TreeNode root){

        if(root == null){
            return;
        }

        traverseInOrder(root.left);
        myList.add(root.val);
        traverseInOrder(root.right);
    }

}
