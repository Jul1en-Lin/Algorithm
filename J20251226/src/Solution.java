public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 哨兵节点
        ListNode head = new ListNode();
        // 指针cur，用于建立新链表
        ListNode cur = head;
        // 标志进位
        int in = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            // 进位确认
            sum += in;
            in = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                sum %= 10;
                in = 1; // 进位
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
        }

        // 判断最后一位是否有进位
        if (in == 1) {
            ListNode node = new ListNode(in);
            cur.next = node;
            cur = cur.next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 哨兵节点
        ListNode head = new ListNode();
        // 指针cur，用于建立新链表
        ListNode cur = head;
        // 标志进位
        int in = 0;

        while (l1 != null || l2 != null || in == 1) {
            if (l1 != null) {
                in += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                in += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(in % 10);
            cur.next = node;
            cur = cur.next;
            in /= 10;
        }
        return head.next;
    }
}
