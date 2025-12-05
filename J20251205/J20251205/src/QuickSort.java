import java.util.Random;

public class QuickSort {
    public int findKthLargest(int[] nums, int k) {
        return qsort(nums, 0, nums.length - 1, k);
    }

    private int qsort(int[] nums, int l, int r, int k) {
        // 判断边界条件，且这里不存在 l > r 的情况
        if (l == r) return nums[l];
        // 随机选择基准元素randomKey
        int randomIndex = l + new Random().nextInt(r - l + 1);
        int randomKey = nums[randomIndex];
        // 根据基准元素，使数组分三区
        int left = l - 1,right = r + 1;
        for (int i = l; i < right; ) {
            if (nums[i] > randomKey) {
                // 放右边，由于交换出的元素是未知的，未扫描，故不能i++
                swap(nums, --right, i);
            }
            else if (nums[i] < randomKey) {
                // 放左边，且交换出的元素已经上一轮扫描过，故i++
                swap(nums, ++left, i);
                i++;
            } else i++; // 重复元素直接跳过
        }

        // 分类讨论：判断第k大落在的区间
        // [l, left] [left + 1, right - 1] [right, r]
        int a = (left - l) + 1, b = (right - 1) - (left + 1) + 1, c = (r - right) + 1; // abc 分别代表不同分区的元素个数
        if (c >= k) {
            // 在 >randomKey 区间，继续寻找
            return qsort(nums, right, r, k);
        } else if (b + c >= k) {
            // 上述 c >= k 不成立 则一定落在 ==randomKey 区间 直接返回
            return randomKey;
        }else {
            // 落在 < key 分区，则找的是 k - b - c的位置，因为 >=key 的都抛弃了，第k 大元素肯定不落在范围内
            return qsort(nums, l, left, k - b - c);
        }
    }

    private void swap(int[] nums,int x ,int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
