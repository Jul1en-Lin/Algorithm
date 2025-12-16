import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 最小 k 个数
public class Solution {
    // 数组排序
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    // 大根堆排序
    public int[] smallestK2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        // 堆排序
        // 创建大根堆 需传入Comparator
        int[] ret = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int x : arr) {
            // 没满的就入堆
            if (queue.size() != k) {
                queue.offer(x);
            }else{
                if (queue.peek() > x) {
                    // 进去
                    queue.poll();
                    queue.offer(x);
                }else{
                    // 下一个
                }
            }
        }

        int index = 0;
        while(queue.size() != 0) {
            ret[index] = queue.poll();
            index++;
        }
        return ret;
    }
}
