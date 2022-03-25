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

public class MiddleLinkList {

    // Solution 1: 将 list 中数字的存入数组再读取数组的 middle  100%
    public static ListNode middleNode1(ListNode head) {
        ListNode[] clone = new ListNode[100];
        int i = 0;
        ListNode cur = head;
        while (cur != null) {
            clone[i++] = cur;
            cur = cur.next;
        }
        return clone[i >>> 1];
    }

    // Solution 2: 先遍历 list 得到长度，再遍历长度的一半  100%
    public static ListNode middleNode2(ListNode head) {
        int i = 0, j = 0;
        ListNode cur = head, curr = head;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        while (j < i >>> 1) {
            curr = curr.next;
            j++;
        }
        return curr;
    }

    // Solution 3: 快慢双指针  100%
    public static ListNode middleNode3(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
