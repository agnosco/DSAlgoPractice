package practice;

import java.util.Arrays;
import java.util.List;

public class MaxSumPathBST {

    public List<Integer> max(TreeNode node) {
        if (node == null) return Arrays.asList(0, Integer.MIN_VALUE);

        List<Integer> leftNodeValue = max(node.left);
        List<Integer> rightNodeValue = max(node.right);

        int leftMax = Math.max(leftNodeValue.get(0), 0);
        int rightMax = Math.max(rightNodeValue.get(0), 0);

        int current = node.val + leftMax + rightMax;

        int pathHere = Math.max(Math.max(leftNodeValue.get(1), rightNodeValue.get(1)), current);

        return Arrays.asList(node.val + Math.max(leftMax, rightMax), pathHere);
    }
}
