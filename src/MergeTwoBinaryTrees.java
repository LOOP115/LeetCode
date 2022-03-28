import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class MergeTwoBinaryTrees {

    // Solution 1: DFS  O(min(t1,t2))  100%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    // Solution 2: BFS  O(min(t1,t2))  14.91%
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }

    // Attempt 1: 思路类似 Solution 1  Beat 100%  对 java 不够熟悉所以代码很冗余
    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode ans = new TreeNode(0);
        merge(root1, root2, ans);
        return ans;
    }

    public static void merge(TreeNode root1, TreeNode root2, TreeNode ans) {
        if (root1 == null && root2 == null) {
            return;
        }
        if (root1 != null && root2 == null) {
            ans.val = root1.val;
            ans.left = root1.left;
            ans.right = root1.right;
            return;
        }
        if (root1 == null && root2 != null) {
            ans.val = root2.val;
            ans.left = root2.left;
            ans.right = root2.right;
            return;
        }
        ans.val = root1.val + root2.val;
        if (root1.left != null || root2.left != null) {
            ans.left = new TreeNode(0);
            merge(root1.left, root2.left, ans.left);
        }
        if (root1.right != null || root2.right != null) {
            ans.right = new TreeNode(0);
            merge(root1.right, root2.right, ans.right);
        }
    }

}
