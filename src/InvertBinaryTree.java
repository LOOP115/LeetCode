import java.util.LinkedList;
import java.util.Stack;

public class InvertBinaryTree {

    // Attempt 1  Recursion  100%
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
    }

    // 官方递归
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 迭代  DFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                exchange(cur);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
        }
        return root;
    }

    // 评论区迭代  BFS  层序遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null)
            return null;
        // 将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode temp = queue.poll();
            // 交换左右节点
            exchange(temp);

            // 如果当前节点的左子树不为空，则放入队列等待后续处理
            if(temp.left!=null) queue.add(temp.left);
            // 如果当前节点的右子树不为空，则放入队列等待后续处理
            if(temp.right!=null) queue.add(temp.right);
        }
        return root;
    }

    // 交换左右节点
    public void exchange(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
