public class Solution {
    int count = 0;
    int[] tmp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        tmp = new int[n];
        mergeSort(nums, 0, n - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 中止条件
        if (left >= right) return;
        // 取中间
        int mid = (right + left) / 2;

        // 继续往下递归
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 分类讨论
        // 优化左右两边都为有序数组(利用暂存数组与双指针来排序)————为了优化查找逆序对的逻辑
        // 如果有序递增的左侧数字都比右侧的某一数字都大，那么左边剩下的肯定也比它大
        // 此时逆序对的数量就能以o(1)的时间复杂度计算
        int cur1 = left, cur2 = mid + 1,i = 0;
        while (cur1 <= mid && cur2 <= right) {
            if (nums[cur1] <= nums[cur2]) {
                // 没有逆序对的情况
                // 将小的放进tmp数组中，并移动cur1指针
                tmp[i++] = nums[cur1++];
            }
            else {
                // nums[cur1] > nums[cur2]的情况
                count += mid - cur1 + 1; // 👈为了优化这里
                tmp[i++] = nums[cur2++]; // 将小的放进tmp中，移动cur2指针
            }
        }

        // 处理部分未放到tmp的有序数组
        // 为什么是剩下的数组都是有序的？————从最底层返回的单个数字就是有序的数组
        // 原本剩下的数字其实也是底下一层返回来的部分有序的数组
        while (cur1 <= mid)
            tmp[i++] = nums[cur1++];
        while (cur2 <= right)
            tmp[i++] = nums[cur2++];

        // 为上一层返回有序数组，注入到nums中
        for (int j = left; j <= right; j++) // 注意j <= right
            nums[j] = tmp[j - left];
    }
}
