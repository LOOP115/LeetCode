import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorder {

    // Attempt 1
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }

    // Attempt 2
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            // 用 prev 记录右节点是否已被加入
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stk.push(root);
                root = root.right;
            }
        }
        return res;
    }

    // Solution 3  Morris 遍历  只操作已经存在的指针（树的空闲指针），因此只需要常数的额外空间
    // 没有左子树的节点只被访问一次，有左子树的节点被访问两次
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                // 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                // 如果前驱节点的右子节点为空, 将前驱节点的右子节点更新为当前节点，当前节点更新为当前节点的左子节点
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    // 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空
                    // 倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点
                    // 当前节点更新为当前节点的右子节点
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        // 最后 add root 和 root 右侧未被添加的节点
        addPath(res, root);
        return res;
    }

    public void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        // 倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点
        int left = res.size() - count; // 左子节点的位置
        int right = res.size() - 1; // 前驱节点的位置
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

}
