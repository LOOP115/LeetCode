public class SearchBST {

    // Attempt 1  Recursion
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }

    // Attempt 2  迭代  Space O(1)
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

}
