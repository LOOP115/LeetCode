import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorder {

    // Attempt 1
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }

    // Attempt 2
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deq = new LinkedList<>();
        while (root != null || !deq.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                deq.push(root);
                root = root.left;
            }
            root = deq.pop();
            root = root.right;
        }
        return res;
    }

    // Solution 3  Morris 遍历  只操作已经存在的指针（树的空闲指针），因此只需要常数的额外空间
    // 没有左子树的节点只被访问一次，有左子树的节点被访问两次
    public List<Integer> preorderTraversal3(TreeNode root) {
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
                // 如果前驱节点的右子节点为空，将当前节点加入答案
                // 并将前驱节点的右子节点更新为当前节点，当前节点更新为当前节点的左子节点
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    // 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空
                    // 当前节点更新为当前节点的右子节点，开始遍历右侧
                    p2.right = null;
                }
            } else {
                // 如果当前节点的左子节点为空，将当前节点加入答案，并遍历当前节点的右子节点
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }

}
