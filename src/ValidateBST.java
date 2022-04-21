import java.util.Deque;
import java.util.LinkedList;

public class ValidateBST {

    // Solution 1  递归  100%
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // Solution 2 中序遍历
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        long min = Long.MIN_VALUE;

        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if (root.val <= min) {
                return false;
            }
            min = root.val;
            root = root.right;
        }
        return true;
    }

}
