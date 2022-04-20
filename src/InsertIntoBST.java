public class InsertIntoBST {

    // 精简递归
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // 题解 迭代
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }

    // Attempt 1  Recursion  100%
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            insert(root.left, root, val);
        } else {
            insert(root.right, root, val);
        }
        return root;
    }

    public void insert(TreeNode curr, TreeNode prev, int val) {
        if (curr == null) {
            curr = new TreeNode(val);
            if (val < prev.val) {
                prev.left = curr;
            } else {
                prev.right = curr;
            }
            return;
        }
        if (val < curr.val) {
            insert(curr.left, curr, val);
        } else {
            insert(curr.right, curr, val);
        }
    }

}
