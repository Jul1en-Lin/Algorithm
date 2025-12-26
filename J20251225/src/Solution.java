import java.util.HashSet;
import java.util.Set;

public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }

    // 快慢指针
    public boolean hasCycle1(ListNode head) {
      if (head == null) return false;
      ListNode cur1 = head;
      ListNode cur2 = cur1;
      while (cur2.next != null && cur2.next.next != null) {
          cur1 = cur1.next;
          cur2 = cur2.next.next;
          if (cur1 == cur2) return true;
      }
      return false;
    }

    /**
    * 哈希表
    */
    public ListNode detectCycle(ListNode head) {
      if (head == null || head.next == null) return null;
      // 哈希表
      Set<ListNode> set = new HashSet<>();
      while (head.next != null) {
          if (set.contains(head)) return head;
          set.add(head);
          head = head.next;
      }
      return null;
    }

    /**
    * 快慢指针 (数学推理)
    */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        // 快慢指针
        ListNode slower = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if (slower == faster) {
                // runner 从head出发
                // (a：head 到入口点的距离，b：入口点到与slower == faster的距离，c：一圈环的距离L - b)
                ListNode runner = head;
                while (runner != slower) {
                    runner = runner.next; // runner 走距离 a 的路径
                    slower = slower.next; // slower 走距离 c 的路径
                }
                // 根据数学推理得 a == c 故runner 与 slower相遇时必定走到入口点
                return runner;
            }
        }
        return null;
    }
  }
}
