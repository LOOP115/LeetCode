import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {

    // Attempt 1  Queue  BFS  100%
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int count = 0;
            List<Integer> layer = new ArrayList<>();
            while (count < size) {
                TreeNode temp = nodes.poll();
                layer.add(temp.val);
                if (temp.left != null) {
                    nodes.offer(temp.left);
                }
                if (temp.right != null) {
                    nodes.offer(temp.right);
                }
                count++;
            }
            res.add(layer);
        }
        return res;
    }

}
