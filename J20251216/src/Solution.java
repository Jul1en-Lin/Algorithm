import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

// 最小 k 个数
public class Solution {
    // 数组排序
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
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

    // 快速排序
    public int[] smallestK3(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++)
            ret[i] = arr[i];
        return ret;
    }

    public void quickSort(int[] num, int l, int r, int k) {
        if (r - l + 1 == k) return;
        // 选取随机元素
        int index = l + new Random().nextInt(r - l + 1);
        int key = num[index];
        // 定义指针 + 分区
        int left = l - 1,right = r + 1;
        for (int cur = l;cur < right; ) {
            if (num[cur] > key) swap(num, cur, --right);
            else if (num[cur] < key) swap(num, cur++, ++left);
            else cur++;
        }

        // 分类讨论
        // [l, left] [left + 1, right - 1] [right, r]
        int a = left - l + 1,b = right - left - 1,c = r - right + 1;
        if (a >= k) quickSort(num, l, left, k);// a == k 的情况会在quickSort的if (r - l + 1 == k)条件中 return
        else if (a + b >= k) return;
        else quickSort(num, right, r, k - a - b);
    }

    public void swap(int[] num, int x, int y) {
        int tmp = num[x];
        num[x] = num[y];
        num[y] = tmp;
    }
}
