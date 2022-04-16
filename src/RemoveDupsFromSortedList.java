public class RemoveDupsFromSortedList {

    // Attempt 1: 一次遍历  100%
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        while (head != null) {
            int val = head.val;
            ListNode temp = head.next;
            // 如果是重复元素就一直遍历
            while (temp != null && temp.val == val) {
                temp = temp.next;
            }
            head.next = temp;
            head = temp;
        }
        return dummy.next;
    }

    // 官方解法，思路一样
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}
