public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 循环解法
        if (head == null || head.next == null) return head;
        // 哨兵节点
        ListNode tmphead = new ListNode();
        tmphead.next = head;

        ListNode cur1 = head; // 定义指针
        ListNode prv = tmphead;// 用来连接每一对交换后的链表，把他们串起来
        while (cur1 != null && cur1.next != null) {
            ListNode cur2 = cur1.next;
            cur1.next = cur2.next;
            cur2.next = cur1;
            prv.next = cur2;
            prv = cur1;
            cur1 = cur1.next;
        }
        return tmphead.next;
    }

    // 递归思想
    public ListNode swapPairs2(ListNode head) {
        // 判断结束条件
        if (head == null || head.next == null) return head;

        // tmp 接收下面递归后返回的新的头节点
        ListNode tmp = swapPairs(head.next.next);
        ListNode cur1 = head;
        ListNode ret = cur1.next; // 最终要返回的新的头节点

        // 交换当前的链表位置
        ret.next = cur1;
        cur1.next = tmp;

        // 返回头节点
        return ret;
    }
}
