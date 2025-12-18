import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    /**
     * 分治归并
     */
    int[] tmp;
    public int[] sortArray(int[] nums) {

        if (nums == null || nums.length == 0) return null;
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 中止条件
        if (left >= right) return;

        // 1. 选取中间点
        int mid = (right + left) / 2;

        // 2. 递归左右区间排序
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 3. 排序(双指针)
        // int[] tmp = new int[right - left + 1];// tmp每次都要new 消耗资源 故放到全局变量中
        int cur1 = left, cur2 = mid + 1, i = 0;
        while (cur1 <= mid && cur2 <= right)
            tmp[i++] = nums[cur1] <= nums[cur2] ? nums[cur1++] : nums[cur2++];

        // 细节问题：cur1 或者 cur2 可能没有走到最后
        // 虽然是两个while 但也只会执行其中一个
        while (cur1 <= mid) tmp[i++] = nums[cur1++];
        while (cur2 <= right) tmp[i++] = nums[cur2++];

        // 4. 归并合到一起
        for (int j = left; j <= right; j++)
            nums[j] = tmp[j - left]; // tmp 要从0开始取
    }

    /**
     * 快排
     */
    public int[] sortArray2(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    public void qsort(int[] nums, int l, int r) {
        // 判断中止条件
        if (l >= r) return;
        // 取随机值
        int key = nums[l + new Random().nextInt(r - l + 1)];
        // 分区
        int left = l - 1,right = r + 1;
        for (int cur = l; cur < right; ) {
            if (nums[cur] > key)
                swap(nums, cur, --right);
            else if (nums[cur] < key)
                swap(nums, cur++, ++left);
            else cur++;
        }

        // 分类讨论
        qsort(nums, l, left);
        qsort(nums, right, r);
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    /**
     * 堆排序
     */
    public int[] sortArray3(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        // 堆排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
        for (int x : nums) {
            queue.offer(x);
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; i++)
            ret[i] = queue.poll();
        return ret;
    }
}
