import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    // Attempt 1  Recursion  100%
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    public boolean check1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check1(p.left, q.right) && check1(p.right, q.left);
    }

    // Attempt 2  迭代  Queue
    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode p, TreeNode q) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(p);
        que.offer(q);

        while (!que.isEmpty()) {
            p = que.poll();
            q = que.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            que.offer(p.right);
            que.offer(q.left);
            que.offer(p.left);
            que.offer(q.right);
        }
        return true;
    }

}
