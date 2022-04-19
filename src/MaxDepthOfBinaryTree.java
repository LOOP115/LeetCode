import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
    public static int max = 0;

    // Attempt 1  DFS  100%
    public int maxDepth(TreeNode root) {
        max = 0;
        dfs(root, 1);
        return max;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            if (level - 1 > max) {
                max = level - 1;
            }
            return;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    // Solution 1  官方 dfs  思路更精简  max depth = max(l,r)+1
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Solution 2 BFS 层序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

}
