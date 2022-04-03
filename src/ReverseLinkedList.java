/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ReverseLinkedList {

    // Iteration  O(n) O(1)
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = new ListNode(head.val);
        while (head != null) {
            curr = new ListNode(head.val);
            curr.next = prev;
            prev = curr;
            head = head.next;
        }
        return curr;
    }

    // 官方 Iteration
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 官方 Recursion，不画图拆解很难看懂  Space: O(n)
    // 也可以利用 stack 思想，更容易理解
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 评论区做法
    public ListNode reverseList3(ListNode head) {
        ListNode ans = null;
        for (ListNode x = head; x != null; x = x.next) {
            ans = new ListNode(x.val,ans);
        }
        return ans;
    }

}
