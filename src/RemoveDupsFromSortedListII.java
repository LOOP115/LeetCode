public class RemoveDupsFromSortedListII {

    // 官方题解  100%
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


    // Attempt 1  100%
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, null);
        ListNode node = dummy;
        ListNode prev = head;
        ListNode curr = head.next;
        while (prev != null) {
            if (prev.next == null) {
                node.next = prev;
                break;
            }
            boolean add = true;
            if (prev.val == curr.val) {
                // Keep traversing if curr is duplicated
                while (prev != null && curr != null && prev.val == curr.val) {
                    prev = prev.next;
                    curr = curr.next;
                }
                add = false;
            }
            if (add) {
                ListNode temp = new ListNode(prev.val);
                node.next = temp;
                node = temp;
            }
            prev = curr;
            if (curr != null) {
                curr = curr.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode test = new ListNode(1, new ListNode(5, new ListNode(5, new ListNode(6, new ListNode(6)))));
        ListNode res = deleteDuplicates1(test);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
