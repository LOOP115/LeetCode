import java.util.*;

public class TwoSumIV {

    // Solution 1  dfs  O(n)
    Set<Integer> set1 = new HashSet<>();
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set1.contains(k - root.val)) {
            return true;
        }
        set1.add(root.val);
        return findTarget1(root.left, k) || findTarget1(root.right, k);
    }

    // Solution 2  bfs  O(n)
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode temp = nodes.poll();
            if (set.contains(k - temp.val)) {
                return true;
            }
            set.add(temp.val);
            if (temp.left != null) {
                nodes.offer(temp.left);
            }
            if (temp.right != null) {
                nodes.offer(temp.right);
            }
        }
        return false;
    }

    // Solution 3  迭代 + 中序遍历 + 双指针  100%
    // 和一开始的思路差不多，本来以为可以借助 BST 实现少于 O(n) 的复杂度，但好像无论怎样都需要全部遍历
    List<Integer> nums = new ArrayList<>();
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }

    public boolean findTarget3(TreeNode root, int k) {
        inorder(root);
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) == k) {
                return true;
            }
            if (nums.get(left) + nums.get(right) < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // Solution 4  解法 3 迭代实现
    // 用两个 stack 分别存储左右的 nodes
    public boolean findTarget4(TreeNode root, int k) {
        TreeNode left = root, right = root;
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        // 存储最左路径的 nodes
        leftStack.push(left);
        while (left.left != null) {
            leftStack.push(left.left);
            left = left.left;
        }
        // 存储最右路径的 nodes
        rightStack.push(right);
        while (right.right != null) {
            rightStack.push(right.right);
            right = right.right;
        }
        // 双指针方法遍历查找
        while (left != right) {
            if (left.val + right.val == k) {
                return true;
            }
            if (left.val + right.val < k) {
                left = getLeft(leftStack);
            } else {
                right = getRight(rightStack);
            }
        }
        return false;
    }

    // 出一进一
    public TreeNode getLeft(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return root;
    }

    public TreeNode getRight(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
        return root;
    }

}
