import java.util.PriorityQueue;

public class HeapSort {
    public int findKthLargest(int[] nums, int k) {
        // 使用堆排序（NlogN）
        // 找第K大的，实际是使用降序，降序用小顶堆
        // PriorityQueue 默认是小顶堆，无需传入Comparator
        // 创造大小为k的
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        // 遍历每个元素
        for (int x : nums) {
            // 如果堆没满，直接加进去
            if (queue.size() != k)
                queue.offer(x);
            else {
                // 开始对比
                if (x > queue.peek()) {
                    queue.poll();
                    queue.offer(x);// offer时PriorityQueue会自动排序，最小的排到堆顶
                } else {
                    // 忽略，下一个
                }
            }
        }
        // 由于queue容量是k，且是小顶堆，所以最顶上那个元素一定是第K大的元素
        return queue.peek();
    }
}
