import java.util.Deque;
import java.util.LinkedList;

public class RemoveNthFromEnd {

    // Solution 1: 计算链表长度  O(L)  100%
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode cur = head;
        int len = getLength(cur);
        int posToDel = len - n;
        // 倒数第n个在表头
        // 这里也可以在表头加一个哑变量（Dummy）达成同样的效果
        if (posToDel == 0) {
            return head.next;
        }
        int i = 0;
        ListNode curr = head;
        while (i < posToDel - 1) {
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    // Solution 2: Use Stack  O(L)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        // Push all the nodes
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // Pop n last nodes
        for (int i=0; i<n; i++) {
            stack.pop();
        }
        // Get the node before the one needs to delete
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    // Solution 3: 双指针，间隔n  O(L)  100%
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        // 当 fast 遍历完成时，slow 处于需要被删除的节点前一位
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        // 找到 fast 所指初始节点
        for (int i=0; i<n; i++) {
            fast = fast.next;
        }
        // 找到需要被删除的节点前一位
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
