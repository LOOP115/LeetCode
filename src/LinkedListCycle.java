import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle {

    // Attempt 1  HashMap
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> cnt = new HashMap<>();
        while (head != null) {
            int count = cnt.getOrDefault(head, 0) + 1;
            if (count > 1) {
                return true;
            }
            cnt.put(head, count);
            head = head.next;
        }
        return false;
    }

    // Solution 1  HashSet 思路和用 HashMap 一样
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // Solution 2  快慢指针  Floyd 判圈算法  100%
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        if (slow == null || slow.next == null) {
            return false;
        }
        ListNode fast = slow.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }

    // 官方快慢指针
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
