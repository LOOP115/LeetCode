public class RemoveLinkedListNodes {

    // Attempt 1  一次遍历  58.64%
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    // Attempt 2  Recursion  100%
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        } else if (head.val == val) {
            // 当前节点需要被删除，跳过该节点继续遍历下一个节点
            return removeElements(head.next, val);
        } else {
            // 当前节点不需要被删除，生成该节点之后的节点并返回当前节点
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    // 官方 Recursion  代码更简洁
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

}
