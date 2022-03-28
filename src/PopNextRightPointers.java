/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.Queue;

public class PopNextRightPointers {

    // Solution 1: 官方层序遍历，比自己的简单一点  O(N)  68.71%
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }

    // Solution 2: 使用已建立的 next 指针，不需要 extra space  100%
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            while (head != null) {
                // Connection 1: 父节点的两个子节点
                head.left.next = head.right;
                // Connection 2: 父节点的右子节点和父节点的 next 的左子节点
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // Update head
                head = head.next;
            }
            // 去下一层最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }

    // Solution 2 递归版
    public Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next != null ? root.next.left : null;
            connect3(root.left);
            connect3(root.right);
        }
        return root;
    }

    // Attempt 1: 在层序遍历基础上改进  O(N)  32.02%
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        // 记录当前层数
        int layer = 0;
        // 记录每层的长度范围
        int range = 1;
        // 记录当前节点是否为 Head
        int isHead = 1;
        // 记录前一个节点
        Node prev = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (range > 0 && isHead == 0) {
                // 此节点不是每层的尾部，将前一个节点的 next 指向该节点
                prev.next = node;
            }
            // 在当前层继续推进
            range--;
            prev = node;
            // 如果前一个节点是 head，更新 isHead
            if (isHead == 1) {
                isHead = 0;
            }
            // 当前层遍历完毕，计算下一层的长度并进入下一层
            if (range == 0) {
                range = (int) Math.pow(2, layer + 1);
                isHead = 1;
                layer++;
            }
            // 层序遍历入列
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
