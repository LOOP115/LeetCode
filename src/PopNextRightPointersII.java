import java.util.LinkedList;
import java.util.Queue;

public class PopNextRightPointersII {

    // 层序遍历 65.88%
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer((node.right));
                }
            }
        }
        return root;
    }

    // 复用 next 指针，构建虚拟头节点  100%
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node curr = root;
        // head 作为下一层的虚拟头节点
        Node head = new Node(0);
        while (curr != null) {
            Node prev = head;
            // 遍历当前层的所有节点并进行连接
            while (curr != null) {
                // 连接非空子节点
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            // 进入下一层的头节点并重制虚拟头节点
            curr = head.next;
            head.next = null;
        }
        return root;
    }

}
